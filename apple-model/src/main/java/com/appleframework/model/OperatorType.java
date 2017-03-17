package com.appleframework.model;

public enum OperatorType {

	TYPE_09("类型9", 9),
	TYPE_08("类型8", 8),
	TYPE_07("类型7", 7),
	TYPE_06("类型6", 6),
	TYPE_05("类型5", 5),
	TYPE_04("类型4", 4),
	TYPE_03("类型3", 3),
	TYPE_02("类型2", 2),
	TYPE_01("类型1", 1);
	
	// 成员变量
	private String name;
	private Integer index;

	// 构造方法
	private OperatorType(String name, Integer index) {
		this.name = name;
		this.index = index;
	}

	// 普通方法
	public static String getName(int index) {
		for (OperatorType c : OperatorType.values()) {
			if (c.getIndex() == index) {
				return c.name;
			}
		}
		return null;
	}

	public static OperatorType get(int index) {
		for (OperatorType c : OperatorType.values()) {
			if (c.getIndex() == index) {
				return c;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
}
