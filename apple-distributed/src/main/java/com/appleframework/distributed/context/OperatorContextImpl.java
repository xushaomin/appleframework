package com.appleframework.distributed.context;

import com.appleframework.context.invoke.OperatorContext;
import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.model.Operator;

public class OperatorContextImpl implements OperatorContext {
	
	private static OperatorContextImpl context;

	static {
		context = new OperatorContextImpl();
	}
	
	public void setOperator(Operator operator) {
		ThreadLocalOperatorContext.getInstance().setOperator(operator);
		DistributedOperatorContext.getInstance().setOperator(operator);
	}
	
	public Operator getOperator() {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		if(null == operator)
			operator = DistributedOperatorContext.getInstance().getOperator();
		return operator;
	}
	
	public void set(String key, String value) {
	}
	
	public static OperatorContext instance() {
		if (context == null) {
			context = new OperatorContextImpl();
		}
		return context;
	}
	
	public static OperatorContext getInstance() {
		return instance();
	}
	
}