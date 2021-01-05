package com.appleframework.logging;

import org.slf4j.Logger;

public class LoggerFactory {

	public static Logger getLogger() {
		StackTraceElement[] sts = Thread.currentThread().getStackTrace();
		return org.slf4j.LoggerFactory.getLogger(sts[2].getClassName());
	}
}