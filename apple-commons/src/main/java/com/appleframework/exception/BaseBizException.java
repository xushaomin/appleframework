package com.appleframework.exception;

/**
 * Base class for all custom exception thrown in AppleFramework
 * 
 * @author Cruise.Xu
 * @date: 2020-12-01
 * 
 */
public abstract class BaseBizException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	protected String status;
	
    protected Integer ret;

    protected String msg;

    public BaseBizException() {
    }
    
    public BaseBizException(Throwable throwable) {
    	super(throwable);
    }

    public BaseBizException(Integer ret, Throwable throwable) {
    	super(throwable);
    	this.ret = ret;
    }
    
    public BaseBizException(String status, Integer ret, Throwable throwable) {
    	super(throwable);
    	this.ret = ret;
    	this.status = status;
    }
    
    public BaseBizException(String msg, Throwable throwable) {
    	super(msg, throwable);
    	this.msg = msg;
    }
    
    public BaseBizException(String status, Integer ret, String msg) {
    	super(msg);
    	this.ret = ret;
    	this.msg = msg;
    	this.status = status;
    }
    
    public BaseBizException(Integer ret, String msg) {
    	super(msg);
    	this.ret = ret;
    	this.msg = msg;
    }
	
	public BaseBizException(Integer ret, String msg, Throwable throwable) {
		super(msg, throwable);
		this.ret = ret;
		this.msg = msg;
	}

	public BaseBizException(String status, Integer ret, String msg, Throwable throwable) {
		super(msg, throwable);
		this.ret = ret;
		this.msg = msg;
		this.status = status;
	}
    
    public BaseBizException(String msg) {
    	super(msg);
    	this.msg = msg;
    }
    
    public BaseBizException(Integer ret) {
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
