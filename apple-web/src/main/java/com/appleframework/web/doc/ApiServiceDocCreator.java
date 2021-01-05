package com.appleframework.web.doc;

import com.appleframework.web.annotation.Api;
import com.appleframework.web.annotation.ApiService;
import org.springframework.context.ApplicationContext;

/**
 * @author tanghc
 */
public class ApiServiceDocCreator extends AbstractApiDocCreator<ApiService, Api> {

    public ApiServiceDocCreator(String defaultVersion, ApplicationContext applicationContext) {
        super(defaultVersion, applicationContext);
    }

    @Override
    protected Class<ApiService> getServiceAnnotationClass() {
        return ApiService.class;
    }

    @Override
    protected Class<Api> getMethodAnnotationClass() {
        return Api.class;
    }

    @Override
    protected com.appleframework.web.bean.Api getApi(Api api) {
        return new com.appleframework.web.bean.Api(api.name(), api.version());
    }
}
