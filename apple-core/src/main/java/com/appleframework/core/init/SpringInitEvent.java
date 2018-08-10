package com.appleframework.core.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * spring成功启动事件
 */
public class SpringInitEvent implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory.getLogger(SpringInitEvent.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		// 防止重复执行
		if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
			// 开始逻辑
			ApplicationContext context = contextRefreshedEvent.getApplicationContext();
			try {
				InitEvent initEvent = context.getBean(InitEvent.class);
				if (initEvent != null) {
					initEvent.init();
				}
			} catch (BeansException e) {
				logger.error("配置了启动事件监听,但是没有配置启动类,启动类需实现class:com.appleframework.core.init.InitEvent");
			}
		}
	}

}
