package com.appleframework.exception;

/**
 * Base class for all custom exception thrown in AppleFramework
 * 
 * @author Cruise.Xu
 * @date: 2020-12-03
 * 
 */
public class UnknownException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	protected String status;
	
    protected Integer ret;

    protected String msg;

    public UnknownException() {
    }
    
    public UnknownException(Throwable throwable) {
    	super(throwable);
    }

    public UnknownException(Integer ret, Throwable throwable) {
    	super(throwable);
    	this.ret = ret;
    }
    
    public UnknownException(String status, Integer ret, Throwable throwable) {
    	super(throwable);
    	this.ret = ret;
    	this.status = status;
    }
    
    public UnknownException(String msg, Throwable throwable) {
    	super(msg, throwable);
    	this.msg = msg;
    }
    
    public UnknownException(String status, Integer ret, String msg) {
    	super(msg);
    	this.ret = ret;
    	this.msg = msg;
    	this.status = status;
    }
    
    public UnknownException(Integer ret, String msg) {
    	super(msg);
    	this.ret = ret;
    	this.msg = msg;
    }
	
	public UnknownException(Integer ret, String msg, Throwable throwable) {
		super(msg, throwable);
		this.ret = ret;
		this.msg = msg;
	}

	public UnknownException(String status, Integer ret, String msg, Throwable throwable) {
		super(msg, throwable);
		this.ret = ret;
		this.msg = msg;
		this.status = status;
	}
    
    public UnknownException(String msg) {
    	super(msg);
    	this.msg = msg;
    }
    
    public UnknownException(Integer ret) {
    	this.ret = ret;
    }

    public Integer getRet() {
		return ret;
	}

	public void setRet(Integer ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
