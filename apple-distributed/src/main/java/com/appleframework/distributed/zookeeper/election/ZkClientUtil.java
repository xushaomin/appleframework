package com.appleframework.distributed.zookeeper.election;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZkClientUtil {
	
	private static ConcurrentHashMap<String, ZkClient> map = new ConcurrentHashMap<String, ZkClient>();
	
	public static ZkClient get(ZkClientInfo zkClientInfo) throws Exception {
		ZkClient zkClient = map.get(zkClientInfo.getId());
		if(null == zkClient) {
			synchronized (ZkClient.class) {
				RetryPolicy retryPolicy = 
		        		new ExponentialBackoffRetry(zkClientInfo.getRetrySleepTime(), zkClientInfo.getMaxRetries());
				CuratorFramework client = CuratorFrameworkFactory.builder()
						.connectString(zkClientInfo.getConnectString())
						.retryPolicy(retryPolicy)
						.connectionTimeoutMs(zkClientInfo.getConnectTimeOut()).build();
				LeaderLatch leaderLatch = new LeaderLatch(client, zkClientInfo.getPath(), zkClientInfo.getId(),
						LeaderLatch.CloseMode.NOTIFY_LEADER);
				ZkClientCache cache = new ZkClientCache();
				ZKClientListener zkClientListener = new ZKClientListener();
				zkClientListener.setCache(cache);
				leaderLatch.addListener(zkClientListener);
				zkClient = new ZkClient(leaderLatch, client);
				zkClient.setCache(cache);
				map.put(zkClientInfo.getId(), zkClient);
				zkClient.startZKClient();
			}
		}
		return zkClient;
	}
}
