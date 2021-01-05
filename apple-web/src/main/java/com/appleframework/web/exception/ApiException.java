package com.appleframework.web.exception;

import com.appleframework.web.message.Error;
import com.appleframework.web.message.Errors;

/**
 * @author tanghc
 */
public class ApiException extends RuntimeException {
	
    private static final long serialVersionUID = 16789476595630713L;

    private Integer code = Errors.SYS_ERROR.getCode();
    private Object data;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(Exception e) {
        super(e);
    }

    public ApiException(Error<Integer> error) {
        this(error.getMsg());
        this.code = error.getCode();
    }

    public ApiException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    public ApiException(String msg, Integer code, Object data) {
        super(msg);
        this.code = code;
        this.data = data;
    }

    public ApiException(Error<Integer> error, Object data) {
        this(error);
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    /**
     * 获取RuntimeException异常，在做dubbo服务时可以用到，因为dubbo处理自定义异常有问题。
     */
    public RuntimeException getRuntimeException() {
        return new RuntimeException(this.getMessage());
    }

}
