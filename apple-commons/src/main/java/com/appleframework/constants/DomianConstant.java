package com.appleframework.constants;

import java.util.HashMap;
import java.util.Map;

public class DomianConstant {

	private static Map<String, String> MANAGEMENT_DOMAIN = new HashMap<>();
	
	static {
		MANAGEMENT_DOMAIN.put("DEV", "admin.appleframework.com");
		MANAGEMENT_DOMAIN.put("FAT", "admin.appleframework.com");
		MANAGEMENT_DOMAIN.put("PRE", "admin.appleframework.com");
		MANAGEMENT_DOMAIN.put("UAT", "admin.appleframework.com");
		MANAGEMENT_DOMAIN.put("PRO", "admin.appleframework.com");
	}
		
	public static String getManagementDomain(String env) {
		return MANAGEMENT_DOMAIN.get(env);
	}

}
