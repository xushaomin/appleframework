package com.appleframework.context.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.MessageSourceAccessor;

public class MessageSourceUtil implements ApplicationContextAware {

	private static MessageSourceAccessor messageSourceAccessor;

	public final void setApplicationContext(ApplicationContext context) throws BeansException{
		if (null == context){
			messageSourceAccessor = null;
		}
		else {
			messageSourceAccessor = new MessageSourceAccessor(context);
		}
	}

	public static MessageSourceAccessor getMessageSourceAccessor() {
		return messageSourceAccessor;
	}
}