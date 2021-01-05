package com.appleframework.web;

import com.appleframework.web.message.ErrorMeta;
import com.appleframework.web.message.Errors;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 默认的结果封装类.
 * 
 * @author tanghc
 *
 */
@XStreamAlias("result")
public class ApiResult implements Result {
	
    private static final long serialVersionUID = -669758664098208583L;

    private Integer code = Errors.SUCCESS.getCode();
    private String msg = Errors.SUCCESS.getMsg();
    private Object data;

    public ApiResult() {
        super();
    }

    public ApiResult(Object data) {
        super();
        this.data = data;
    }

    public static ApiResult success(Object data) {
        ApiResult result = new ApiResult();
        result.setData(data);
        return result;
    }

    public static ApiResult error(ErrorMeta errorMeta) {
        ApiResult result = new ApiResult();
        result.setCode(errorMeta.getCode());
        result.setMsg(errorMeta.getMsg());
        return result;
    }

    @Override
    public void setCode(Object code) {
        this.code = Integer.valueOf(code +"");
    }

    @Override
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

}
