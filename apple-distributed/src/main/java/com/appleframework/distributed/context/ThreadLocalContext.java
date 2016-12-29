package com.appleframework.distributed.context;

import com.appleframework.context.invoke.InvokeContext;
import com.appleframework.model.Operator;

public class ThreadLocalContext implements InvokeContext {
	
	private static ThreadLocal<Operator> local = new ThreadLocal<Operator>();
	
	public void setOperator(Operator operator) {
		local.set(operator);
	}
	
	public Operator getOperator() {
		return local.get();
	}
}