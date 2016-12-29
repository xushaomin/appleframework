package com.appleframework.web.springmvc.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.appleframework.context.invoke.InvokeContext;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;


/**
 * @author Cruise.Xu
 */
public class OperatorInterceptor extends HandlerInterceptorAdapter {
	
	private static String SESSION_USER_KEY = "CAS_USER";

	@Resource
	private InvokeContext invokeContext;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
		Object user = httpServletRequest.getSession().getAttribute(SESSION_USER_KEY);
		if (null != user) {
			Operator operator = Operator.creat(OperatorType.OSS, user.toString());
			invokeContext.setOperator(operator);
		}
		return true;
	}

	public void setInvokeContext(InvokeContext invokeContext) {
		this.invokeContext = invokeContext;
	}

}