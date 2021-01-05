package com.appleframework.launcher.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import com.appleframework.launcher.props.AppProperties;

/**
 * <p>
 * 自动装配类
 * </p>
 *
 * @package: com.appleframework.launcher.config
 * @description: 自动装配类
 * @author: cruise.xu
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties({AppProperties.class})
public class LauncherAutoConfiguration {
}
