/**
 *
 * 日    期：12-2-23
 */
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
public class ServiceUnavailableException extends AppleException {

	private static final long serialVersionUID = -3259477976501742491L;

	private static final String SERVICE_UNAVAILABLE = "unavailable";

	public ServiceUnavailableException() {
	}

	public ServiceUnavailableException(Class<?> clazz) {
		super(SERVICE_UNAVAILABLE);
		this.clazz = getInterfaceName(clazz);
	}
	
	public ServiceUnavailableException(Throwable throwable) {
		super(SERVICE_UNAVAILABLE, throwable);
	}

	public ServiceUnavailableException(Class<?> clazz, Throwable throwable) {
		super(SERVICE_UNAVAILABLE, throwable);
		this.clazz = getInterfaceName(clazz);
	}

	public ServiceUnavailableException(Class<?> clazz, Throwable throwable, Object... params) {
		super(SERVICE_UNAVAILABLE, throwable);
		this.clazz = getInterfaceName(clazz);
		this.params = params;
	}
}
