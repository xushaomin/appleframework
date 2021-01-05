package com.appleframework.web.message;

import java.util.Locale;

import com.appleframework.web.ApiContext;
import com.appleframework.web.exception.ApiException;

/**
 * 错误对象
 * 
 * @author tanghc
 *
 */
public class ErrorMeta implements Error<Integer> {

    public ErrorMeta(String isvModule, Integer code, String msg) {
        super();
        this.isvModule = isvModule;
        this.code = code;
        this.msg = msg;
    }
    
    public ErrorMeta(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    private String isvModule;
    private Integer code;
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    public String getIsvModule() {
        return isvModule;
    }

    public void setIsvModule(String isvModule) {
        this.isvModule = isvModule;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    
    /**
     * @param params i18n属性文件参数。顺序对应文件中的占位符{0},{1}
     * @return 返回exception
     */
    public ApiException getException(Object... params) {
        return this.getException(ApiContext.getLocal(), params);
    }
    
    /**
     * 返回exception，并且附带数据
     * @param data 数据
     * @param params i18n属性文件参数。顺序对应文件中的占位符{0},{1}
     * @return 返回exception
     */
    public ApiException getExceptionData(Object data, Object... params) {
        ApiException ex = this.getException(ApiContext.getLocal(), params);
        ex.setData(data);
        return ex;
    }

    public ApiException getException(Locale locale, Object... params) {
        Error<Integer> error = ErrorFactory.getError(this, locale, params);
        return new ApiException(error);
    }

}
