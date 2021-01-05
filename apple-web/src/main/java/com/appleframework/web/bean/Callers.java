package com.appleframework.web.bean;

import com.appleframework.web.ApiMeta;

import java.lang.reflect.InvocationTargetException;

/**
 * @author tanghc
 */
public class Callers {

    public static Object call(ApiMeta apiMeta, Object methodArgu) throws InvocationTargetException, IllegalAccessException {
        Object invokeResult;
        if (methodArgu == null) {
            invokeResult = apiMeta.getMethod().invoke(apiMeta.getHandler());
        } else {
            invokeResult = apiMeta.getMethod().invoke(apiMeta.getHandler(), methodArgu);
        }
        return invokeResult;
    }
}
