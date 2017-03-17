package com.appleframework.distributed.context;

import com.alibaba.dubbo.rpc.RpcContext;
import com.appleframework.context.invoke.OperatorContext;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;
import com.appleframework.model.OperatorUser;

public class DistributedOperatorContext implements OperatorContext {
	
	private static DistributedOperatorContext context;
	
	static {
		context = new DistributedOperatorContext();
	}
	
	public void setOperator(Operator operator) {
		RpcContext.getContext().setAttachment(KEY_ID, operator.getUser().getId());
		RpcContext.getContext().setAttachment(KEY_NAME, operator.getUser().getName());
		RpcContext.getContext().setAttachment(KEY_EXTEND, operator.getUser().getExtend());
		RpcContext.getContext().setAttachment(KEY_TYPE, String.valueOf(operator.getType().getIndex()));
	}
	
	public Operator getOperator() {
		String id = RpcContext.getContext().getAttachment(KEY_ID);
		String extend = RpcContext.getContext().getAttachment(KEY_EXTEND);
		if(null == id && null == extend) {
			return null;
		}
		String name = RpcContext.getContext().getAttachment(KEY_NAME);
		String type = RpcContext.getContext().getAttachment(KEY_TYPE);
		return Operator.creat(OperatorType.get(Integer.parseInt(type)), new OperatorUser(id, name, extend));
	}
	
	public void set(String key, String value) {
		RpcContext.getContext().setAttachment(key, value);
	}
	
	public static OperatorContext instance() {
		if (context == null) {
			context = new DistributedOperatorContext();
		}
		return context;
	}
	
	public static OperatorContext getInstance() {
		return instance();
	}
	
}