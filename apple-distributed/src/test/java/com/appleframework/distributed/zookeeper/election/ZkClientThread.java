package com.appleframework.distributed.zookeeper.election;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.appleframework.distributed.zookeeper.election.ZkClient;

public class ZkClientThread extends Thread {

	private ZkClient zkClient;

	public ZkClient getZkClient() {
		return zkClient;
	}

	public void setZkClient(ZkClient zkClient) {
		this.zkClient = zkClient;
	}

	private static Log log = LogFactory.getLog(ZkClientThread.class);

	@Override
	public void run() {
		while (true) {

			try {
				//第一步leader验证 
				if (!zkClient.hasLeadership()) {
					log.info("当前服务不是leader");
					Thread.sleep(3000);
					continue;
				} else {
					log.info("当前服务是leader");
				}
				Thread.sleep(1000);
				log.info("Test01 do it... ");
			} catch (Exception e) {

			}

		}

	}
}
