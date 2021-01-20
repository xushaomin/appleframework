package com.appleframework.distributed.context;

import com.appleframework.model.Operator;

public abstract interface OperatorContext {
	
	public static final String KEY_ID = "opid";
	public static final String KEY_NAME = "opname";
	public static final String KEY_TYPE = "optype";
	public static final String KEY_EXTEND = "opextend";

	public abstract void setOperator(Operator paramOperator);

	public abstract Operator getOperator();
}
