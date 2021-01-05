package com.appleframework.spring;

import org.springframework.core.env.ConfigurableEnvironment;

public class ConfigurableEnvironmentUtil {

	private static ConfigurableEnvironment environment = null;

	/**
	 * @return the environment
	 */
	public static ConfigurableEnvironment getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public static void setEnvironment(ConfigurableEnvironment environment) {
		ConfigurableEnvironmentUtil.environment = environment;
	}
	
}
