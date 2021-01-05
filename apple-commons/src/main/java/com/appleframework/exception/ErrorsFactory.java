package com.appleframework.exception;

/**
 * 异常工厂类
 *
 * @author craig.chen
 * @Title: ErrorFactory.java
 * @Package com.appleframework.exception
 * @date 2020/6/17 11:43 上午
 */
public class ErrorsFactory {

	public static ServiceException newError(ErrorCode err) {
		return new ServiceException(err.getCode(), err.getMsg());
	}

	public static ServiceException newError(ErrorCode err, String msg) {
		return new ServiceException(err.getCode(), msg);
	}

	public static ServiceException newError(ErrorCode err, Throwable throwable) {
		return new ServiceException(err.getCode(), err.getMsg(), throwable);
	}

	public static ServiceException newError(Class<?> clazz, ErrorCode err) {
		return new ServiceException(clazz, err);
	}

	public static ServiceException newError(Class<?> clazz, ErrorCode err, Throwable throwable) {
		return new ServiceException(clazz, err, throwable);
	}

	public static ServiceException newError(Class<?> clazz, ErrorCode err, Object... params) {
		return new ServiceException(clazz, err, params);
	}
}
