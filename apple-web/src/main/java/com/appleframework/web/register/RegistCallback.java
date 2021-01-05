package com.appleframework.web.register;

import com.appleframework.web.ApiConfig;

/**
 * @author tanghc
 */
public interface RegistCallback {

    /**
     * 接口注册完毕后出发
     * @param apiConfig
     */
    void onRegistFinished(ApiConfig apiConfig);
    
}
