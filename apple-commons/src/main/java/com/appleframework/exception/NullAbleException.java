package com.appleframework.exception;

/**
 * 非空异常校验类<br>
 * 
 * @author cruise.xu
 * @since 2011-05-03
 * @see Exception
 */
@Deprecated
public class NullAbleException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String nullField;

	/**
	 * 构造函数1
	 * 
	 * @param 非空校验类
	 */
	public NullAbleException() {
		super("对象不能为空,请检查.");
	}

	/**
	 * 构造函数2
	 * 
	 * @param 非空校验类
	 */
	public NullAbleException(Class<?> cs) {
		super("对象不能为空,请检查.[" + cs + "]");
	}

	/**
	 * 构造函数3
	 * 
	 * @param pNullField
	 *            异常附加信息
	 */
	public NullAbleException(String pNullField) {
		super("对象属性[" + pNullField + "]不能为空,请检查.");
		this.setNullField(pNullField);
	}

	public String getNullField() {
		return nullField;
	}

	public void setNullField(String nullField) {
		this.nullField = nullField;
	}
}
