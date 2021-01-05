package com.appleframework.launcher.service;

import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * <p>
 * launcher 扩展 用于一些组件发现
 * </p>
 *
 * @package: com.appleframework.launcher.service
 * @description: launcher 扩展 用于一些组件发现
 * @author: cruise.xu
 */
public interface LauncherService {

    /**
     * 启动时 处理 SpringApplicationBuilder
     *
     * @param builder SpringApplicationBuilder
     * @param appName 服务名
     * @param profile 配置名
     * @param isLocalDev 是否本地开发
     */
    void launcher(SpringApplicationBuilder builder, String appName, String profile, boolean isLocalDev);

}
