package com.appleframework.web.register;

import org.springframework.context.ApplicationContext;

import com.appleframework.web.ApiConfig;

/**
 * @author tanghc
 */
public interface Initializer {

    /**
     * 初始化操作
     * @param applicationContext spring上下文
     * @param apiConfig 配置内容
     */
    void init(ApplicationContext applicationContext, ApiConfig apiConfig);
}
