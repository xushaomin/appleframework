package com.appleframework.model;

import java.io.Serializable;

public class OperatorUser implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String id;
	protected String name;
	protected String extend;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OperatorUser() {
	}

	public OperatorUser(String id, String name) {
		this.id = id;
		this.name = name;
		this.extend = name + "(" + id + ")";
	}
	
	public OperatorUser(String extend) {
		this.setExtend(extend);
	}
	
	public OperatorUser(String id, String name, String extend) {
		this.id = id;
		this.name = name;
		this.extend = extend;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
		if(null != extend && extend.contains("(") && extend.contains("")) {
			name = extend.substring(0, extend.indexOf("("));
			id = extend.substring(extend.indexOf("(") + 1, extend.length() - 1);
		}
	}

	@Override
	public String toString() {
		if(null != id)
			return name + "(" + id + ")";
		else
			return extend;
	}
	
	public String getUserAsString(){
		return toString();
	}
	
	public Integer getUserAsInteger(){
		return Integer.parseInt(id);
	}
	
	public Long getUserAsLong(){
		return Long.parseLong(id);
	}

}
