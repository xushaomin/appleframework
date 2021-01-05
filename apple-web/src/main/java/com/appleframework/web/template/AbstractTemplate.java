package com.appleframework.web.template;

import com.appleframework.web.ApiConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tanghc
 */
public class AbstractTemplate {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected ApiConfig apiConfig;

    public AbstractTemplate(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }
}
