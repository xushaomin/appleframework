package com.appleframework.context.utils;

import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.core.utils.ReflectionUtility;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorUser;

public class ContextOperatorUtility {
	
	public static void fillOperatorForCreate(Object object) {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		if(null != operator) {
			try {
				Integer type = operator.getType().getIndex();
				ReflectionUtility.setFieldValue(object, "createType", type);
			} catch (Exception e) {
			}
			try {
				OperatorUser user = operator.getUser();
				ReflectionUtility.setFieldValue(object, "createBy", user.toString());
			} catch (Exception e) {
			}			
		}
	}
	
	public static void fillOperatorForUpdate(Object object) {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		
		if(null != operator) {
			try {
				Integer type = operator.getType().getIndex();
				ReflectionUtility.setFieldValue(object, "updateType", type);
			} catch (Exception e) {
			}
			try {
				OperatorUser user = operator.getUser();
				ReflectionUtility.setFieldValue(object, "updateBy", user.toString());
			} catch (Exception e) {
			}			
		}
	}
	
}