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

	public ServiceException(String code) {
		super(code);
		this.code = code;
	}
	
	public ServiceException(String code, String message) {
		super(code);
		this.code = code;
		this.message = message;
	}
	
	public ServiceException(String code, Throwable throwable) {
		super(code, throwable);
		super.code = code;
	}

	public ServiceException(Class<?> clazz, String code) {
		super(code);
		this.code = code;
		this.clazz = getInterfaceName(clazz);
	}
	
	public ServiceException(Class<?> clazz, String code, Object... params) {
		super(code);
		this.code = code;
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}

	public ServiceException(Class<?> clazz, String code, Throwable throwable) {
		super(code, throwable);
		this.code = code;
		this.clazz = getInterfaceName(clazz);
	}
	
	public ServiceException(Class<?> clazz, String code, Throwable throwable, Object... params) {
		super(code, throwable);
		this.code = code;
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}

	public String getKey() {
		if(null == clazz)
			return RSP + "." + code;
		else
			return RSP + transform(clazz) + ERROR + code;
	}
	
	public ServiceException(String code, String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
        this.code = code;
        this.message = String.format(messageFormat, args);
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
