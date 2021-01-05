package com.appleframework.web.exception;

/**
 * @author tanghc
 */
public class BusinessParamException extends ApiException {
	
    private static final long serialVersionUID = 1L;

    public BusinessParamException(String msg, Integer code) {
        super(msg, code);
    }

}
