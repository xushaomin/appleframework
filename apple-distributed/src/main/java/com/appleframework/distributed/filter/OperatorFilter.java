package com.appleframework.distributed.filter;

import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;
import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.distributed.context.DistributedOperatorContext;
import com.appleframework.model.Operator;

public class OperatorFilter implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
    	Operator operator = DistributedOperatorContext.getInstance().getOperator();
    	if(null != operator) {
    		ThreadLocalOperatorContext.getInstance().setOperator(operator);
    	}
    	return invoker.invoke(invocation);
    }
}
