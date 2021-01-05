package com.appleframework.web.monitor;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.appleframework.web.ApiContext;
import com.appleframework.web.ApiParam;
import com.appleframework.web.exception.BusinessParamException;
import com.appleframework.web.interceptor.ApiInterceptorAdapter;

/**
 * 负责监控的拦截器
 * 
 * @author tanghc
 */
public class MonitorInterceptor extends ApiInterceptorAdapter implements Visitor {

    private static final String START_TIME = MonitorInterceptor.class.getSimpleName() + "_START_TIME";

    private volatile ExecutorService executorService = null;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object serviceObj, Object argu)
            throws Exception {
        this.in(request, serviceObj, argu);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object serviceObj,
            Object argu, Object result, Exception e) throws Exception {
        this.out(request, serviceObj, argu, result, e);
    }

    @Override
    public void in(HttpServletRequest request, Object serviceObj, Object argu) {
        request.setAttribute(START_TIME, System.currentTimeMillis());
    }

    @Override
    public void out(final HttpServletRequest request, Object serviceObj, final Object argu, final Object result, final Exception e) {
    	boolean isSuccess = false;
    	if(null == e) {
    		isSuccess = true;
    	}
    	else if(e instanceof BusinessParamException) {
            return;
        }
        else {
        	Class<?> exceptionClass = ApiContext.getApiConfig().getServiceExceptionClass();
        	if (e.getClass().equals(exceptionClass)) {
        		isSuccess = true;
            }
        	if(e instanceof InvocationTargetException) {
            	InvocationTargetException ex = (InvocationTargetException)e;
            	if(ex.getTargetException().getClass().equals(exceptionClass)) {
            		isSuccess = true;
            	}
            }
        }
        
        if (executorService == null) {
            synchronized (MonitorInterceptor.class) {
                if (executorService == null) {
                    executorService = Executors.newFixedThreadPool(ApiContext.getApiConfig().getMonitorExecutorSize());
                }
            }
        }
        final long endTime = System.currentTimeMillis();
        final Long startTime = (Long) request.getAttribute(START_TIME);
        final MonitorStore store = this.getMonitorStore();
        final ApiParam param = ApiContext.getApiParam();
        if(param != null) {
            final ApiParam input = param.clone();
            if(isSuccess) {
            	executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        store.stat(input, startTime, endTime, argu, result, null);
                    }
                });
            }
            else {
            	executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        store.stat(input, startTime, endTime, argu, result, e);
                    }
                });
            }
        }
    }

    public MonitorStore getMonitorStore() {
        return ApiContext.getApiConfig().getMonitorStore();
    }

}