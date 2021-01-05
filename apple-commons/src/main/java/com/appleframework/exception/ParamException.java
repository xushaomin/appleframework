package com.appleframework.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author cruise.xu
 * @version 1.0
 */
@Deprecated
public class ParamException extends AppleException {

	private static final long serialVersionUID = 1L;

	private Map<String, String> errors = new HashMap<String, String>();
	
	public ParamException() {
		super();
	}
	
	public ParamException(Integer code, String param, String msg) {
		this.code = code;
		errors.put(param, msg);
	}
	
	
	/**
    * 实例化异常
    * 
    * @param param
    * @param message
    * @return
    */
   public ParamException newInstance(Integer ret, String param, String message) {
       return new ParamException(ret, param, message);
   }

}
