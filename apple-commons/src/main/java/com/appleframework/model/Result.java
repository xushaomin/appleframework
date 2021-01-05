package com.appleframework.model;

import java.io.Serializable;

public class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 返回的错误码
	 */
	private String code;

	/**
	 * 返回的错误消息
	 */
	private String msg;

	/**
	 * 返回的数据
	 * <p>
	 * 成功或者失败都有可能有数据
	 */
	private T data;

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}

}
