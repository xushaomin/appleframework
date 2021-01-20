package com.appleframework.distributed.utils;

import com.appleframework.context.invoke.ThreadLocalOperatorContext;
import com.appleframework.model.Operator;
import com.appleframework.model.OperatorUser;

public class ContextOperatorUtility {

	private static String KEY_ID = "id";
	private static String KEY_NAME = "name";

	private static String KEY_CREATE_TYPE = "createType";
	private static String KEY_CREATE_BY = "createBy";

	private static String KEY_UPDATE_TYPE = "updateType";
	private static String KEY_UPDATE_BY = "updateBy";

	public static void fillOperatorForCreate(Object object, String key) {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		if (null != operator) {
			try {
				if (null == ReflectionUtility.getFieldValue(object, KEY_CREATE_TYPE)) {
					Integer type = operator.getType().getIndex();
					ReflectionUtility.setFieldValue(object, KEY_CREATE_TYPE, type);
				}
			} catch (Exception e) {
			}
			try {
				OperatorUser user = operator.getUser();
				String createBy = null;
				if (null == key || key.equals(KEY_ID)) {
					createBy = user.getId();
				} else if (key.equals(KEY_NAME)) {
					createBy = user.getName();
				} else {
					createBy = user.getExtend();
				}
				if (null == ReflectionUtility.getFieldValue(object, KEY_CREATE_BY)) {
					ReflectionUtility.setFieldValue(object, KEY_CREATE_BY, createBy);
				}
			} catch (Exception e) {
			}
		}
	}

	public static void fillOperatorForUpdate(Object object, String key) {
		Operator operator = ThreadLocalOperatorContext.getInstance().getOperator();
		if (null != operator) {
			try {
				if (null == ReflectionUtility.getFieldValue(object, KEY_UPDATE_TYPE)) {
					Integer type = operator.getType().getIndex();
					ReflectionUtility.setFieldValue(object, KEY_UPDATE_TYPE, type);
				}
			} catch (Exception e) {
			}
			try {
				OperatorUser user = operator.getUser();
				String updateBy = null;
				if (null == key || key.equals(KEY_ID)) {
					updateBy = user.getId();
				} else if (key.equals(KEY_NAME)) {
					updateBy = user.getName();
				} else {
					updateBy = user.getExtend();
				}
				if (null == ReflectionUtility.getFieldValue(object, KEY_UPDATE_BY)) {
					ReflectionUtility.setFieldValue(object, KEY_UPDATE_BY, updateBy);
				}
			} catch (Exception e) {
			}
		}
	}

}