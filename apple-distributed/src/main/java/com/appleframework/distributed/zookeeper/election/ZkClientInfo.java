package com.appleframework.distributed.zookeeper.election;

import java.io.Serializable;

public class ZkClientInfo implements Serializable {

	private static final long serialVersionUID = 1L;
		
	// 客户端ID
	private String id = "1";
	
	// 连接信息字符串
	private String connectString = "127.0.0.1";
	
	// 节点路径
	private String path = "/apple/election";
	
	// 连接超时时间
	private Integer connectTimeOut = 5000;
	
	// 最大连接次数
	private Integer maxRetries = 3;
	
	// 重连休眠时间
	private Integer retrySleepTime = 5000;

	public String getConnectString() {
		return connectString == null ? null : connectString.replaceAll("//s+", "");
	}

	public void setConnectString(String connectString) {
		this.connectString = connectString;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getConnectTimeOut() {
		return connectTimeOut;
	}

	public void setConnectTimeOut(Integer connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public Integer getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(Integer maxRetries) {
		this.maxRetries = maxRetries;
	}

	public Integer getRetrySleepTime() {
		return retrySleepTime;
	}

	public void setRetrySleepTime(Integer retrySleepTime) {
		this.retrySleepTime = retrySleepTime;
	}

	@Override
	public String toString() {
		return "{\"id\":\"" + id + "\",\"connectString\":\"" + connectString + "\",\"path\":\"" + path
				+ "\",\"connectTimeOut\":\"" + connectTimeOut + "\",\"maxRetries\":\"" + maxRetries
				+ "\",\"retrySleepTime\":\"" + retrySleepTime + "\"}";
	}

}