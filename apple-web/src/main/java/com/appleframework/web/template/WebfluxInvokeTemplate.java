package com.appleframework.web.template;

import com.appleframework.web.ApiConfig;
import com.appleframework.web.support.ResponseHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tanghc
 */
public class WebfluxInvokeTemplate extends InvokeTemplate {

    public WebfluxInvokeTemplate(ApiConfig apiConfig, ResponseHandler responseHandler) {
        super(apiConfig, responseHandler);
    }

    @Override
    protected void afterInvoke(HttpServletRequest request, HttpServletResponse response, Object result) {
    }
}