package com.appleframework.distributed.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;
import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.distributed.context.DistributedOperatorContext;
import com.appleframework.model.Operator;

@Activate(group = { Constants.PROVIDER, Constants.CONSUMER })
public class OperatorFilter implements Filter {
	public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
		if(RpcContext.getContext().isConsumerSide()) {
			Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
			if (null != operator) {
				DistributedOperatorContext.getInstance().setOperator(operator);
			}
		}
		else if(RpcContext.getContext().isProviderSide()) {
			Operator operator = DistributedOperatorContext.getInstance().getOperator();
			if (null != operator) {
				ThreadLocalOperatorContext.getInstance().setOperator(operator);
			}
		}
		else {
			
		}
		return invoker.invoke(invocation);
	}
}
