package com.appleframework.distributed.context;

import com.appleframework.model.Operator;

public class ThreadLocalContext {
	
	private static ThreadLocal<Operator> local = new ThreadLocal<Operator>();
	
	public static void setOperator(Operator operator) {
		local.set(operator);
	}
	
	public static Operator getOperator() {
		return local.get();
	}
}