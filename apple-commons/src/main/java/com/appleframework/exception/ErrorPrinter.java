package com.appleframework.exception;

import org.slf4j.Logger;

import com.appleframework.tools.json.JSONObject;

/**
 * 异常打印处理，如果是业务异常则打印异常码和异常信息，否则打印堆栈
 *
 * @author craig.chen
 * @Title: ErrorPrinter.java
 * @Package com.appleframework.exception
 * @date 2020/6/17 11:15 上午
 */
public class ErrorPrinter {

	public static void println(Logger logger, Exception e){
		if(e instanceof ServiceException){
			ServiceException se = (ServiceException) e;
			Object[] params = se.getParams();
			if(params ==null){
				logger.warn("errorMsg:{} ,errorCode:{}, data:{}",e.getMessage(),se.getCode());
			}else {
				logger.warn("errorMsg:{} ,errorCode:{}, data:{}",e.getMessage(),se.getCode(),JSONObject.toJSONString(params));
			}
		}else {
			logger.error(e.getMessage(),e);
		}
	}

	public static void println(Logger logger, Exception e, Object paramDTO){
		logger.info("query or update parameters, paramDTO:{}", JSONObject.toJSONString(paramDTO));
		if(e instanceof ServiceException){
			ServiceException se = (ServiceException) e;
			Object[] params = se.getParams();
			if(params ==null){
				logger.warn("errorMsg:{} ,errorCode:{}, data:{}",e.getMessage(),se.getCode());
			}else {
				logger.warn("errorMsg:{} ,errorCode:{}, data:{}",e.getMessage(),se.getCode(), JSONObject.toJSONString(params));
			}
		}else {
			logger.error(e.getMessage(),e);
		}
	}
}
