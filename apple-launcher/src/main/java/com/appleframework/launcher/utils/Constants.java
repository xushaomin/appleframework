package com.appleframework.launcher.utils;

import java.text.MessageFormat;

import com.appleframework.constants.DomianConstant;

public class Constants {
		
	private static String KEY_MANAGEMENT_ON     = "management.on";
		
	private static String MANAGEMENT_URL        = "http://{0}/admin/management/event";
		
	public static String getManagementUrl() {
		return MessageFormat.format(MANAGEMENT_URL, getManagementDomain());  
	}
	
	private static String getManagementDomain() {
		String env = getDeployEnv();
		return DomianConstant.getManagementDomain(env);
	}
	
	public static boolean isManagementOn() {
		String mOn = System.getProperty(KEY_MANAGEMENT_ON);
		if(null != mOn) {
			return Boolean.parseBoolean(mOn);
		}
		return false;
	}
	
	public static String getDeployEnv() {
		String env = System.getProperty(com.appleframework.constants.KeyConstant.KEY_APP_ENV);
		if(null == env) {
			env = System.getProperty(com.appleframework.constants.KeyConstant.KEY_ENV);
		}
		return env;
	}

}
