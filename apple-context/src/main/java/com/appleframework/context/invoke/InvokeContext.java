package com.appleframework.context.invoke;

import com.appleframework.model.Operator;

public interface InvokeContext {
	
	public void setOperator(Operator operator);
	
	public Operator getOperator();
}