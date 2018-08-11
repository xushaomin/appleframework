package com.appleframework.distributed.zookeeper.election;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatchListener;

public class ZKClientListener implements LeaderLatchListener {

	private static Log log = LogFactory.getLog(ZKClientListener.class);

	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private ZkClientCache cache;
	
	@Override
	public void isLeader() {
		log.info(dateFormat.format(new Date()) + "当前服务已变为leader,将从事消费业务");
		cache.setIsLeader(true);
	}

	@Override
	public void notLeader() {
		log.info(dateFormat.format(new Date()) + "当前服务已退出leader,不再从事消费业务");
		cache.setIsLeader(false);
	}

	public ZkClientCache getCache() {
		return cache;
	}

	public void setCache(ZkClientCache cache) {
		this.cache = cache;
	}

}