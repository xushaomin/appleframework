package com.appleframework.web.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;

/**
 * @author Cruise.Xu
 */
public class OperatorInterceptor extends HandlerInterceptorAdapter {

	private static String SESSION_USER_KEY = "CAS_USER";
	
	private Integer operatorType;

	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
			throws Exception {
		Object user = httpServletRequest.getSession().getAttribute(SESSION_USER_KEY);
		if (null != user) {
			if(null == operatorType)
				operatorType = OperatorType.TYPE_01.getIndex();
			Operator operator = Operator.creat(operatorType, user.toString());
			ThreadLocalOperatorContext.getInstance().setOperator(operator);
		}
		return true;
	}

	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}

}