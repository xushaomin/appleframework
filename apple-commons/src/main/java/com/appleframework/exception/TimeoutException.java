package com.appleframework.exception;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author cruise.xu
 * @version 1.0
 */
@Deprecated
public class TimeoutException extends AppleException {

	private static final long serialVersionUID = -4131567927036108840L;

    private static final String SERVICE_TIMEOUT = "-timeout";

    public TimeoutException() {
    }

    public TimeoutException(Class<?> clazz) {
		super(SERVICE_TIMEOUT);
		this.clazz = getInterfaceName(clazz);
	}
	
	public TimeoutException(Throwable throwable) {
		super(SERVICE_TIMEOUT, throwable);
	}

	public TimeoutException(Class<?> clazz, Throwable throwable) {
		super(SERVICE_TIMEOUT, throwable);
		this.clazz = getInterfaceName(clazz);
	}

	public TimeoutException(Class<?> clazz, Throwable throwable, Object... params) {
		super(SERVICE_TIMEOUT, throwable);
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}
}
