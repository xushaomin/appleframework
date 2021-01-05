package com.appleframework.version;

import java.util.HashMap;
import java.util.Map;

public class VersionMap {
	
	private static Map<String, String> versionMap = new HashMap<String, String>();

	public static Map<String, String> get() {
		return versionMap;
	}

	public static void add(String moduleName, String version) {
		if(null != version && version.length() > 0) {
			versionMap.put(moduleName, version);
		}
	}
	
}
