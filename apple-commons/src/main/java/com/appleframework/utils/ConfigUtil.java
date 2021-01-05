package com.appleframework.utils;

import org.springframework.util.StringUtils;

import com.appleframework.constants.KeyConstant;

public class ConfigUtil {
    
    public static String getEnv() {
    	String env = System.getenv(KeyConstant.KEY_APP_ENV);
        if (null != env){
            return env;
        }
        else {
        	env = System.getProperty(KeyConstant.KEY_APP_ENV);
        	if (null != env){
        		return env;
        	}
        }
        return null;
    }
    
    public static String getAppId() {
    	String appId = System.getProperty(KeyConstant.KEY_APP_ID);
        if (null != appId){
            return appId;
        }
        else {
        	appId = System.getProperty(KeyConstant.KEY_APP_ID);
        	if (null != appId){
                return appId;
            }
        }
        return null;
    }
    
    public static String getManagementPort() {
    	String managementPort = System.getProperty(KeyConstant.KEY_MANAGEMENT_PORT);
        if (null != managementPort){
            return managementPort;
        }
        else {
        	managementPort = System.getProperty(KeyConstant.KEY_MANAGEMENT_PORT);
        	if (null != managementPort){
        		return managementPort;
        	}
        }
        return null;
    }
    
    public static String getServerPort() {
    	String serverPort = System.getProperty(KeyConstant.KEY_SERVER_PORT);
        if (null != serverPort){
            return serverPort;
        }
        else {
        	return null;
        }
    }
    
    public static void setManagementPort(String port) {
    	System.setProperty(KeyConstant.KEY_MANAGEMENT_PORT, port);
    }
    
    public static boolean isDev() {
		String env = getEnv();
		if (!StringUtils.isEmpty(env) && !env.equalsIgnoreCase(KeyConstant.KEY_ENV_DEV)) {
			return false;
		}
		return true;
	}
    
}
