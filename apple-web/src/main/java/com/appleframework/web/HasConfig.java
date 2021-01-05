package com.appleframework.web;

/**
 * @author tanghc
 */
public interface HasConfig {
    /**
     * 设置config
     * @param apiConfig
     */
    void setApiConfig(ApiConfig apiConfig);

    /**
     * 获取config
     * @return 返回ApiConfig
     */
    ApiConfig getApiConfig();
}
