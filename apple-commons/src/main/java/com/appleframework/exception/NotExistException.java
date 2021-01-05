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
 * @author cruise
 * @version 1.0
 */
@Deprecated
public class NotExistException extends AppleException {

	private static final long serialVersionUID = -2467323337391884616L;
	
	// 注意，这个不能删除，否则无法进行流化
	public NotExistException() {
	}

	private String clazz;

	private Object[] params;

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}


}
