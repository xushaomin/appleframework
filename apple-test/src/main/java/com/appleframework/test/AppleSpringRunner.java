package com.appleframework.test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.runners.model.InitializationError;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ObjectUtils;

import com.appleframework.launcher.AppleApplication;
import com.appleframework.launcher.service.LauncherService;

/**
 * <p>
 * 设置启动参数
 * </p>
 *
 * @package: com.appleframework.test
 * @description: 设置启动参数
 * @author: cruise.xu
 */
public class AppleSpringRunner extends SpringJUnit4ClassRunner {

	private static final Logger log = LoggerFactory.getLogger(AppleSpringRunner.class);

    public AppleSpringRunner(Class<?> clazz) throws InitializationError, NoSuchFieldException, IllegalAccessException {
        super(clazz);
        setUpTestClass(clazz);
    }

    private void setUpTestClass(Class<?> clazz) throws NoSuchFieldException, IllegalAccessException {
    	AppleTest scaffoldTest = AnnotationUtils.getAnnotation(clazz, AppleTest.class);
        if (scaffoldTest == null) {
            throw new AppleTestException(String.format("%s 必须包含 @AppleTest 注解.", clazz));
        }
        String appName = scaffoldTest.appId();
        String profile = scaffoldTest.profile();
        boolean isLocalDev = AppleApplication.isLocalDev();
        Properties props = System.getProperties();
        props.setProperty("spring.application.name", appName);
        props.setProperty("spring.profiles.active", profile);
        props.setProperty("spring.banner.location", "classpath:apple_banner.txt");
        props.setProperty("app.id", appName);
        props.setProperty("app.env", profile);
        props.setProperty("app.is-local", String.valueOf(isLocalDev));
        log.error("---[junit.test]:[{}]---启动中，读取到的环境变量:[{}]", appName, profile);

        // 是否加载自定义组件
        if (!scaffoldTest.enableLoader()) {
            return;
        }
        ServiceLoader<LauncherService> loader = ServiceLoader.load(LauncherService.class);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(clazz);
        // 启动组件
        loader.forEach(launcherService -> launcherService.launcher(builder, appName, profile, isLocalDev));
        // 反射出 builder 中的 props，兼容用户扩展
        Field field = SpringApplicationBuilder.class.getDeclaredField("defaultProperties");
        field.setAccessible(true);
        @SuppressWarnings("unchecked") Map<String, Object> defaultProperties = (Map<String, Object>) field.get(builder);
        if (!ObjectUtils.isEmpty(defaultProperties)) {
            props.putAll(defaultProperties);
        }
    }

}
