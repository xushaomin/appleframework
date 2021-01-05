package com.appleframework.model;

import java.io.Serializable;

public class Operator implements Serializable {

	private static final long serialVersionUID = -3380428902609264726L;

	protected OperatorUser user; // 操作者用户

	protected OperatorType type; // 操作者类型

	public Operator() {
	}

	public Operator(OperatorType type, OperatorUser user) {
		this.type = type;
		this.user = user;
	}

	public static Operator creat(OperatorType type, OperatorUser user) {
		return new Operator(type, user);
	}

	public static Operator creat(OperatorType type, String id, String name) {
		return new Operator(type, new OperatorUser(id, name));
	}
	
	public static Operator creat(OperatorType type, String extend) {
		return new Operator(type, new OperatorUser(extend));
	}

	public static Operator creat(int type, OperatorUser user) {
		OperatorType operatorType = OperatorType.get(type);
		return new Operator(operatorType, user);
	}

	public static Operator creat(int type, String extend) {
		OperatorType operatorType = OperatorType.get(type);
		return new Operator(operatorType, new OperatorUser(extend));
	}
	
	public OperatorUser getUser() {
		return user;
	}

	public void setUser(OperatorUser user) {
		this.user = user;
	}

	public OperatorType getType() {
		return type;
	}

	public void setType(OperatorType type) {
		this.type = type;
	}
	
	public String getUserAsString(){
		if(null != user)
			return user.toString();
		else
			return null;
	}
	
	public Long getUserAsLong(){
		if(null != user)
			return user.getUserAsLong();
		else
			return null;
	}
	
	public Integer getUserAsInteger() {
		if(null != user)
			return user.getUserAsInteger();
		else
			return null;
	}

}
