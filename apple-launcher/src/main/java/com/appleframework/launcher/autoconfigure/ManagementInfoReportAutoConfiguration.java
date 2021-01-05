package com.appleframework.launcher.autoconfigure;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import com.appleframework.launcher.utils.Constants;
import com.appleframework.tools.json.JSONObject;
import com.appleframework.tools.net.NetUtil;
import com.appleframework.tools.util.HttpRequestUtil;
import com.appleframework.utils.HostUtil;
import com.appleframework.version.VersionMap;


@Configuration
public class ManagementInfoReportAutoConfiguration implements ApplicationListener<ApplicationReadyEvent> {

	private static Logger logger = LoggerFactory.getLogger(ManagementInfoReportAutoConfiguration.class);

	private static String UNKNOWN = "UNKNOWN";
	
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
		String managementUrl = Constants.getManagementUrl();
		ManagementInfo props = getProperties();
		boolean success = false;
		for (int i = 1; i <= 3; i++) {
			if (postMessage(props, managementUrl, i)) {
				success = true;
				break;
			}
		}
		if (!success) {
			logger.debug("通知监控中心失败，请检查" + managementUrl + "是否配置有效!");
		}
    }
    
	private boolean postMessage(ManagementInfo props, String managementUrl, int time) {
		try {
			logger.debug("第" + time + "次发送监控同步数据通知");
			String result = null;
	    	String param = JSONObject.toJSONString(props);

			result = HttpRequestUtil.sendBodyJson(managementUrl, param);
			if (null != result && result.length() > 0) {
				return true;
			}
		} catch (Exception e) {
			logger.debug("通过httpclient发送监控同步数据通知失败");
		}
		return false;
	}
	

	private ManagementInfo getProperties() {
		ManagementInfo info = new ManagementInfo();
		String hostName = HostUtil.getHostIp();
		List<String> runtimeParameters = this.getRuntimeParameters();
		info.setAppId(getAppId());
		info.setNodeIp(NetUtil.getIpByHost(hostName));
		info.setNodeHost(hostName);
		info.setInstallPath(getInstallPath());
		info.setDeployEnv(Constants.getDeployEnv());
		//props.put("log.level", LoggingContainerFactory.getRootLoggerLevelString());
		info.setJavaVersion(System.getProperty("java.version"));
		info.setJvmParam(runtimeParameters.toString().replace("[", "").replace("]", ""));
		info.setMemMax(this.getRuntimeParameter(runtimeParameters, "-Xmx"));
		info.setMemMin(this.getRuntimeParameter(runtimeParameters, "-Xms"));
		info.setServerPort(getServerPort());
		info.setManagementPort(getManagementPort());
		info.setAssemblyList(VersionMap.get());
		return info;
	}
	
	private String getInstallPath() {
		return System.getProperty("user.dir");
	}
		
	private String KEY_APP_ID = "app.id";
	
	private String getAppId() {
		String appId = System.getProperty(KEY_APP_ID);
		if (null == appId) {
			appId = UNKNOWN;
		}
		return appId;
	}
	
	private String KEY_SERVER_PORT = "server.port";
	
	private String getServerPort() {
		String port = System.getProperty(KEY_SERVER_PORT);
		if (null == port) {
			port = "8080";
		}
		return port;
	}
	
	private String KEY_MANAGEMENT_PORT = "management.port";
	
	private String getManagementPort() {
		String port = System.getProperty(KEY_MANAGEMENT_PORT);
		if (null == port) {
			port = "0";
		}
		return port;
	}

	
	private List<String> getRuntimeParameters() {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
		List<String> rList = new ArrayList<String>();
		List<String> aList = bean.getInputArguments();
		for (String key : aList) {
			if(key.indexOf("-X") > -1) {
				if(key.indexOf("bootclasspath") == -1) {
					rList.add(key);
				}
			}
		}
		return rList;
	}
	
	//解析启动参数JMX_MEM="-server -Xmx4g -Xms2g -Xmn512m -XX:PermSize=128m -Xss256k"
	private String getRuntimeParameter(List<String> runtimeParameters, String parameter) {
		String value = UNKNOWN;
		for (String key : runtimeParameters) {
			if(key.indexOf(parameter) > -1) {
				value = key.substring(parameter.length());
			}
		}
		return value;
	}
	
	class ManagementInfo {
		
		private String appId;
		private String nodeIp;
		private String nodeHost;
		private String installPath;
		private String deployEnv;
		// props.put("log.level", LoggingContainerFactory.getRootLoggerLevelString());
		private String javaVersion;
		private String jvmParam;
		private String memMax;
		private String memMin;
		private String serverPort = "0";
		private String managementPort = "0";
		private Map<String, String> assemblyList;

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getNodeIp() {
			return nodeIp;
		}

		public void setNodeIp(String nodeIp) {
			this.nodeIp = nodeIp;
		}

		public String getNodeHost() {
			return nodeHost;
		}

		public void setNodeHost(String nodeHost) {
			this.nodeHost = nodeHost;
		}

		public String getInstallPath() {
			return installPath;
		}

		public void setInstallPath(String installPath) {
			this.installPath = installPath;
		}

		public String getDeployEnv() {
			return deployEnv;
		}

		public void setDeployEnv(String deployEnv) {
			this.deployEnv = deployEnv;
		}

		public String getJavaVersion() {
			return javaVersion;
		}

		public void setJavaVersion(String javaVersion) {
			this.javaVersion = javaVersion;
		}

		public String getJvmParam() {
			return jvmParam;
		}

		public void setJvmParam(String jvmParam) {
			this.jvmParam = jvmParam;
		}

		public String getMemMax() {
			return memMax;
		}

		public void setMemMax(String memMax) {
			this.memMax = memMax;
		}

		public String getMemMin() {
			return memMin;
		}

		public void setMemMin(String memMin) {
			this.memMin = memMin;
		}

		public String getServerPort() {
			return serverPort;
		}

		public void setServerPort(String serverPort) {
			this.serverPort = serverPort;
		}

		public String getManagementPort() {
			return managementPort;
		}

		public void setManagementPort(String managementPort) {
			this.managementPort = managementPort;
		}

		public Map<String, String> getAssemblyList() {
			return assemblyList;
		}

		public void setAssemblyList(Map<String, String> assemblyList) {
			this.assemblyList = assemblyList;
		}
	}


}
