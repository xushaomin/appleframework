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
	}
	
	public OperatorUser(String extend) {
		this.extend = extend;
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

}
