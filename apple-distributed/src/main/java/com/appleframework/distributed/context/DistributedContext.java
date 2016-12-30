package com.appleframework.distributed.context;

import com.alibaba.dubbo.rpc.RpcContext;
import com.appleframework.context.invoke.InvokeContext;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;

public class DistributedContext implements InvokeContext {
	
	private static DistributedContext context;
	
	private static String KEY_ID   = "opid";
	private static String KEY_TYPE = "optype";

	public void setOperator(Operator operator) {
		RpcContext.getContext().setAttachment(KEY_TYPE, String.valueOf(operator.getType().getIndex()));
		RpcContext.getContext().setAttachment(KEY_ID, operator.getUserAsString());
	}
	
	public Operator getOperator() {
		String id = RpcContext.getContext().getAttachment(KEY_ID);
		String type = RpcContext.getContext().getAttachment(KEY_TYPE);
		return Operator.creat(OperatorType.get(Integer.parseInt(type)), id);
	}
	
	public static DistributedContext instance() {
		if (context == null) {
			context = new DistributedContext();
		}
		return context;
	}
	
	public static DistributedContext getInstance() {
		if (context == null) {
			context = new DistributedContext();
		}
		return context;
	}
	
}