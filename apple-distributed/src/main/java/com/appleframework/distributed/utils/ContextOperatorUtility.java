package com.appleframework.distributed.utils;

import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.core.utils.ReflectionUtility;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorUser;

public class ContextOperatorUtility {

	private static String KEY_ID = "id";

	public static void fillOperatorForCreate(Object object, String key) {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		if (null != operator) {
			try {
				Integer type = operator.getType().getIndex();
				ReflectionUtility.setFieldValue(object, "createType", type);
			} catch (Exception e) {
			}
			try {
				OperatorUser user = operator.getUser();
				String createBy = null;
				if(null == key || key.equals(KEY_ID)) {
					createBy = user.getId();
				}
				else {
					createBy = user.getExtend();
				}
				ReflectionUtility.setFieldValue(object, "createBy", createBy);
			} catch (Exception e) {
			}
		}
	}

	public static void fillOperatorForUpdate(Object object, String key) {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		if (null != operator) {
			try {
				Integer type = operator.getType().getIndex();
				ReflectionUtility.setFieldValue(object, "updateType", type);
			} catch (Exception e) {
			}
			try {
				OperatorUser user = operator.getUser();
				String updateBy = null;
				if(null == key || key.equals(KEY_ID)) {
					updateBy = user.getId();
				}
				else {
					updateBy = user.getExtend();
				}
				ReflectionUtility.setFieldValue(object, "updateBy", updateBy);
			} catch (Exception e) {
			}
		}
	}

}