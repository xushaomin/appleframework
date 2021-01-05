package com.appleframework.version;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class VersionUtil {
	
	private static Map<String, String> map = new HashMap<>();
	private static boolean isRead = false;
	
	public static String getVersion(String bundleName) {
		initRead();
		return map.get(bundleName);
	}
	
	private static void initRead() {
		if(isRead) {
			return;
		}
		try {
			Enumeration<URL> resources = VersionUtil.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (resources.hasMoreElements()) {
				Manifest manifest = new Manifest(resources.nextElement().openStream());
				Attributes attrs = manifest.getMainAttributes();
				if (attrs == null) {
					continue;
				}
				String name = attrs.getValue("Bundle-Name");
				String version = attrs.getValue("Bundle-Version");
				if(null != name && null != version) {
					map.put(name, version);
				}
			}
		} catch (Exception e) {
			// skip it
		}
		isRead = true;
	}
	
}
