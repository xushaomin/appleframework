package com.appleframework.context.invoke;

import java.util.HashMap;
import java.util.Map;

import com.appleframework.model.Operator;
import com.appleframework.model.OperatorType;
import com.appleframework.model.OperatorUser;

public class ThreadLocalOperatorContext implements OperatorContext {
		
	private static ThreadLocalOperatorContext context;
	
	private static ThreadLocal<Map<String, String>> threadLocal;
	
	static {
		threadLocal = new ThreadLocal<Map<String, String>>();
		context = new ThreadLocalOperatorContext();
	}
	
	public void setOperator(Operator operator) {
		Map<String, String> map = this.getMap();
		map.put(KEY_ID, operator.getUser().getId());
		map.put(KEY_NAME, operator.getUser().getName());
		map.put(KEY_EXTEND, operator.getUser().getExtend());
		map.put(KEY_TYPE, String.valueOf(operator.getType().getIndex()));
		threadLocal.set(map);
	}
	
	public Operator getOperator() {
		Map<String, String> map = this.getMap();
		String id = map.get(KEY_ID);
		String extend = map.get(KEY_EXTEND);
		
		if(null == id && null == extend) {
			return null;
		}
		String name = map.get(KEY_NAME);
		String type = map.get(KEY_TYPE);
		
		return Operator.creat(OperatorType.get(Integer.parseInt(type)), new OperatorUser(id, name, extend));
	}
	
	public Map<String, String> getMap(){
		Map<String, String> map = threadLocal.get();
		if(null == map) {
			map = new HashMap<String, String>();
		}
		return map;
	}
	
	
	public void set(String key, String value) {
		Map<String, String> map = this.getMap();
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
}