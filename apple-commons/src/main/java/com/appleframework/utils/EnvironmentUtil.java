package com.appleframework.utils;

import org.springframework.core.env.ConfigurableEnvironment;

public class EnvironmentUtil {

	private static ConfigurableEnvironment environment;

	public static ConfigurableEnvironment getEnvironment() {
		return environment;
	}

	public static void setEnvironment(ConfigurableEnvironment environment) {
		EnvironmentUtil.environment = environment;
	}

}
