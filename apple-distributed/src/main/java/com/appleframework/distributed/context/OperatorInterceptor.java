package com.appleframework.distributed.context;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.PatternMatchUtils;

import com.appleframework.distributed.utils.ContextOperatorUtility;

public class OperatorInterceptor implements MethodInterceptor {
	
	private String fieldKey;

	private List<String> ignoreBeanNameList = new ArrayList<String>();

	public Object invoke(MethodInvocation method) throws Throwable {   
		Object[] objects = method.getArguments();
		if (objects.length > 0) {
			Object object = objects[0];
			try {
				String methodName = method.getMethod().getName();
				if (this.ignoreBeanNameList.size() > 0) {
					for (String mappedName : this.ignoreBeanNameList) {
						if (isMatch(methodName, mappedName)) {
							return method.proceed();
						}
					}
				}
				if (methodName.startsWith("insert") || methodName.startsWith("save")) {
					ContextOperatorUtility.fillOperatorForCreate(object, fieldKey);
				} 
				else if (methodName.startsWith("update")) {
					ContextOperatorUtility.fillOperatorForUpdate(object, fieldKey);
				} else {
					
				}
			} catch (Exception e) {
			}
		}
		return method.proceed(); // 让调用链往下执行
	}

	protected boolean isMatch(String beanName, String mappedName) {
		return PatternMatchUtils.simpleMatch(mappedName, beanName);
	}
	
	public void setIgnoreBeanNameList(List<String> ignoreBeanNameList) {
		this.ignoreBeanNameList = ignoreBeanNameList;
	}

	public void setIgnoreRegexs(String ignoreRegexs) {
		if(null != ignoreRegexs && !ignoreRegexs.equals("null")) {
			if(ignoreRegexs.replaceAll(" ", "").length() > 0) {
				String[] ignoreRegexss = ignoreRegexs.trim().split(",");
				for (String ignoreRegex : ignoreRegexss) {
					ignoreBeanNameList.add(ignoreRegex);
				}
			}
		}
	}

	public void setFieldKey(String fieldKey) {
		this.fieldKey = fieldKey;
	}

}