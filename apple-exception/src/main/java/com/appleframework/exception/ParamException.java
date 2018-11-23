/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-5
 */
package com.appleframework.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 徐少敏
 * @version 1.0
 */
public class ParamException extends AppleException {

	private static final long serialVersionUID = 1L;

	private Map<String, String> errors = new HashMap<String, String>();
	
	public ParamException() {
		super();
	}

	
	public ParamException(String param, String message) {
		this.code = param;
		this.message = message;
		errors.put(param, message);
	}
	
	
	/**
    * 实例化异常
    * 
    * @param param
    * @param message
    * @return
    */
   public ParamException newInstance(String param, String message) {
       return new ParamException(param, message);
   }

}
