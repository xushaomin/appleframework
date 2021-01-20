package com.appleframework.distributed.context;

import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;
import com.appleframework.model.OperatorUser;
import java.util.HashMap;
import java.util.Map;

public class ThreadLocalOperatorContext implements OperatorContext {
	
	private static ThreadLocalOperatorContext context;
	private static ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<Map<String, String>>();

	public void setOperator(Operator operator) {
		Map<String, String> map = getMap();
		map.put("opid", operator.getUser().getId());
		map.put("opname", operator.getUser().getName());
		map.put("opextend", operator.getUser().getExtend());
		map.put("optype", String.valueOf(operator.getType().getIndex()));
		threadLocal.set(map);
	}

	public Operator getOperator() {
		Map<String, String> map = getMap();
		String id = (String) map.get("opid");
		String extend = (String) map.get("opextend");

		if ((null == id) && (null == extend)) {
			return null;
		}
		String name = (String) map.get("opname");
		String type = (String) map.get("optype");

		return Operator.creat(OperatorType.get(Integer.parseInt(type)), new OperatorUser(id, name, extend));
	}

	public Map<String, String> getMap() {
		Map<String, String> map = (Map<String, String>) threadLocal.get();
		if (null == map) {
			map = new HashMap<String, String>();
		}
		return map;
	}

	public void set(String key, String value) {
		Map<String, String> map = getMap();
		map.put(key, value);
		threadLocal.set(map);
	}

	public static OperatorContext instance() {
		if (context == null) {
			context = new ThreadLocalOperatorContext();
		}
		return context;
	}

	public static OperatorContext getInstance() {
		return instance();
	}

	static {
		context = new ThreadLocalOperatorContext();
	}
}