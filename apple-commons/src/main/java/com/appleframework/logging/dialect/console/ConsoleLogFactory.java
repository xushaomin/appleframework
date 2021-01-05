package com.appleframework.logging.dialect.console;

import com.appleframework.logging.Log;
import com.appleframework.logging.LogFactory;

/**
 * 利用System.out.println()打印日志
 * @author cruise.xu
 *
 */
public class ConsoleLogFactory extends LogFactory {
	
	public ConsoleLogFactory() {
		super("Console Logging");
	}
	

	/**
	 * 获得日志对象
	 *
	 * @param name 日志对象名
	 * @return 日志对象
	 */
	public Log getLog(String name) {
		return new ConsoleLog(name);
	}

	/**
	 * 获得日志对象
	 *
	 * @param clazz 日志对应类
	 * @return 日志对象
	 */
	public  Log getLog(Class<?> clazz) {
		return new ConsoleLog(clazz);
	}
	
	/**
	 * 获得日志对象
	 *
	 * @param name 日志对象名
	 * @return 日志对象
	 */
	public static Log get(String name) {
		return new ConsoleLog(name);
	}

	/**
	 * 获得日志对象
	 *
	 * @param clazz 日志对应类
	 * @return 日志对象
	 */
	public static Log get(Class<?> clazz) {
		return new ConsoleLog(clazz);
	}

	@Override
	public Log createLog(String name) {
		return new ConsoleLog(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new ConsoleLog(clazz);
	}

}
