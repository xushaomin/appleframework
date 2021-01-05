package com.appleframework.launcher;

import com.appleframework.version.ModuleVersion;
import com.appleframework.version.VersionMap;
import com.appleframework.version.VersionUtil;

public class Version implements ModuleVersion {
		
	private String moduleName = "apple-launcher";

	@Override
	public String getModule() {
		return moduleName;
	}

	@Override
	public String getVersion() {
		return VersionUtil.getVersion(moduleName);
	}
	
	public static void printVersion() {
		Version version = new Version();
		VersionMap.add(version.getModule(), version.getVersion());
	}
	
	public static String version() {
		Version version = new Version();
		return version.getVersion();
	}

}
