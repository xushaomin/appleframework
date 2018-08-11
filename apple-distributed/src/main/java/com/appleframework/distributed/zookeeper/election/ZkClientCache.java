package com.appleframework.distributed.zookeeper.election;

public class ZkClientCache {

	private boolean isLeader = false;

	public Boolean getIsLeader() {
		return isLeader;
	}

	public void setIsLeader(Boolean isLeader) {
		this.isLeader = isLeader;
	}

}
