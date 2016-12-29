package com.appleframework.distributed.context;

import com.alibaba.dubbo.rpc.RpcContext;
import com.appleframework.context.invoke.InvokeContext;
import com.appleframework.model.Operator;

public class DistributedContext implements InvokeContext {
	
	private static String KEY = "operator";

	public void setOperator(Operator operator) {
		RpcContext.getContext().set(KEY, operator);
	}
	
	public Operator getOperator() {
		return (Operator)RpcContext.getContext().get(KEY);
	}
}