package com.appleframework.launcher.server;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import com.appleframework.launcher.utils.IpUtil;

/**
 * <p>
 * 服务器信息
 * </p>
 *
 * @package: com.appleframework.launcher.server
 * @description: 服务器信息
 * @author: cruise.xu
 */
@Configuration
public class ServerInfo implements SmartInitializingSingleton {

	private final ServerProperties serverProperties;
	private String hostName;
	private String ip;
	private Integer port;
	private String ipWithPort;

	@Autowired(required = false)
	public ServerInfo(ServerProperties serverProperties) {
		this.serverProperties = serverProperties;
	}

	@Override
	public void afterSingletonsInstantiated() {
		this.hostName = IpUtil.getHostName();
		this.ip = IpUtil.getHostIp();
		this.port = ObjectUtils.isEmpty(serverProperties.getPort()) ? 8080 : serverProperties.getPort();
		this.ipWithPort = String.format("%s:%d", ip, port);
	}

	public ServerProperties getServerProperties() {
		return serverProperties;
	}

	public String getHostName() {
		return hostName;
	}

	public String getIp() {
		return ip;
	}

	public Integer getPort() {
		return port;
	}

	public String getIpWithPort() {
		return ipWithPort;
	}

}
