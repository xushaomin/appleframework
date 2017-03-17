package com.appleframework.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.appleframework.context.invoke.OperatorContext;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;
import com.appleframework.web.util.ServletUtil;

/**
 * @author Cruise.Xu
 */
public class OperatorFilter implements Filter {
	
	protected  Logger logger = Logger.getLogger(getClass());

	public static String SESSION_CAS_KEY = "CAS_USER";

	private OperatorContext operatorContext;
	
	/**
	 * 过滤地址集合
	 */
	protected RequestURIFilter excludeFilter;

	/**
	 * 过滤地址
	 */
	private String exclusions = null;
	
	private String sessionKey;

	public void destroy() {
	}

	public boolean isExcluded(String path) {
		// 如果指定了excludes，并且当前requestURI匹配任何一个exclude pattern，
		// 则立即放弃控制，将控制还给servlet engine。
		// 但对于internal path，不应该被排除掉，否则internal页面会无法正常显示。
		if (excludeFilter != null && excludeFilter.matches(path)) {
			return true;
		}
		return false;
	}

	/**
	 * 过滤逻辑：首先判断单点登录的账户是否已经存在本系统中， 如果不存在使用用户查询接口查询出用户对象并设置在Session中
	 * 
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String path = ServletUtil.getResourcePath(httpRequest);
        if (isExcluded(path)) {
            filterChain.doFilter(request, response);
            return;
        }
        
		if (null == sessionKey)
			sessionKey = SESSION_CAS_KEY;
		Object user = httpRequest.getSession().getAttribute(sessionKey);
		if (null != user) {
			Operator operator = Operator.creat(OperatorType.TYPE_01, user.toString());
			operatorContext.setOperator(operator);
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ApplicationContext ctx = getApplicationContext(filterConfig);
		this.operatorContext = ctx.getBean(OperatorContext.class);
		if (this.operatorContext == null) {
			logger.error("在Spring容器中未找到" + OperatorContext.class.getName() + "的Bean。");
		}
	        
		// 获取需要过滤拦截地址
		if(null == exclusions)
			excludeFilter = new RequestURIFilter(exclusions);
	}

	public void setExclusions(String exclusions) {
		this.exclusions = exclusions;
	}

	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
	
	private ApplicationContext getApplicationContext(FilterConfig filterConfig) {
        return (ApplicationContext) filterConfig.getServletContext().getAttribute(
                WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
    }

}
