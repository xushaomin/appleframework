package com.appleframework.launcher.autoconfigure;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import com.appleframework.spring.ApplicationContextUtil;
import com.appleframework.spring.ConfigurableEnvironmentUtil;
import com.appleframework.spring.SpringBeanDefinitionUtil;

@Configuration
public class ApplicationContextAutoConfiguration
		implements ApplicationContextAware, EnvironmentPostProcessor, BeanDefinitionRegistryPostProcessor {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContextUtil.setApplicationContext(applicationContext);
	}

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		ConfigurableEnvironmentUtil.setEnvironment(environment);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		SpringBeanDefinitionUtil.setBeanFactory(beanFactory);
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		SpringBeanDefinitionUtil.setBeanRegistry(registry);
	}

}
