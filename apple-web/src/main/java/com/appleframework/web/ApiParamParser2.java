package com.appleframework.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.appleframework.web.bean.Consts;
import com.appleframework.web.util.RequestUtil;

/**
 * 参数解析默认实现
 *
 * @author tanghc
 */
public class ApiParamParser2 implements ParamParser {
	
    @Override
	public ApiParam parse(HttpServletRequest request) {
		Map<String, Object> params = RequestUtil.convertRequestParamsToMap(request);
		ApiParam param = this.toApiParam(params);
		this.bindRestParam(param, request);
		return param;
	}
    
    protected ApiParam toApiParam(Map<String, Object> data) {
        return new ApiParam(data);
    }
    
    protected void bindRestParam(ApiParam param, HttpServletRequest request) {
    	String name = (String)request.getAttribute(Consts.REST_PARAM_NAME);
    	String version = (String)request.getAttribute(Consts.REST_PARAM_VERSION);
    	if(name != null) {
    		param.setName(name);
    	}
    	if(version != null) {
    		param.setVersion(version);
    	}
    	param.setStandardMode(false);
    }
}
