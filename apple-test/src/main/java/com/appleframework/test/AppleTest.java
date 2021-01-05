package com.appleframework.test;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * <p>
 * 简化 测试
 * </p>
 *
 * @package: com.appleframework.test
 * @description: 简化 测试
 * @author: cruise.xu
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AppleTest {
    /**
     * 服务名：appId
     *
     * @return appId
     */
    @AliasFor("appId") String value() default "apple-test";

    /**
     * 服务名：appName
     *
     * @return appName
     */
    @AliasFor("value") String appId() default "apple-test";

    /**
     * profile
     *
     * @return profile
     */
    String profile() default "dev";

    /**
     * 启用 ServiceLoader 加载 launcherService
     *
     * @return 是否启用
     */
    boolean enableLoader() default false;
}
