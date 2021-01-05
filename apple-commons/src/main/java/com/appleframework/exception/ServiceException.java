package com.appleframework.exception;

/**
 * Base class for all custom exception thrown in AppleFramework
 * 
 * @author Cruise.Xu
 * @date: 2012-10-15
 * 
 */
public class ServiceException extends AppleException {

	private static final long serialVersionUID = 7696865849245536841L;

	public ServiceException() {
		super();
	}

	public ServiceException(String msg) {
		super(msg);
	}
	
	public ServiceException(Integer code, String msg) {
		super(code, msg);
	}

	public ServiceException(Integer code, Throwable throwable) {
		super(throwable);
		super.code = code;
	}

	public ServiceException(Integer code, String msg, Throwable throwable) {
		super(msg, throwable);
		super.code = code;
		super.msg = msg;
	}


	public ServiceException(Class<?> clazz, ErrorCode err) {
		super(err.getCode(), err.getMsg());
		this.clazz = getInterfaceName(clazz);
	}
	
	public ServiceException(Class<?> clazz, ErrorCode err, Object... params) {
		super(err.getCode(), err.getMsg());
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}

	public ServiceException(Class<?> clazz, ErrorCode err, Throwable throwable) {
		super(err.getCode(), err.getMsg(), throwable);
		this.clazz = getInterfaceName(clazz);
	}
	
	/*
	 public ServiceException(Class<?> clazz, Integer ret, Throwable throwable, Object... params) {
		super(ret, throwable);
		this.ret = ret;
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}
	*/
	
	public Integer genCode() {
		return code;
	}
	
	public ServiceException(Integer code, String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
        this.code = code;
        this.msg = String.format(messageFormat, args);
    }
	
	/**
    * 实例化异常
    * 
    * @param messageFormat
    * @param args
    * @return
    */
   public ServiceException newInstance(String messageFormat, Object... args) {
       return new ServiceException(this.code, messageFormat, args);
   }

}
