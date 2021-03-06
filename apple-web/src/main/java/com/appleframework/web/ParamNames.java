package com.appleframework.web;

import java.util.HashSet;
import java.util.Set;

/**
 * 请求参数名定义
 *
 * @author tanghc
 */
public class ParamNames {
    public static volatile String API_NAME = "name";

    public static volatile String VERSION_NAME = "version";

    public static volatile String APP_KEY_NAME = "app_key";

    public static volatile String DATA_NAME = "data";

    public static volatile String TIMESTAMP_NAME = "timestamp";

    public static volatile String SIGN_NAME = "sign";

    public static volatile String FORMAT_NAME = "format";

    public static volatile String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static volatile String ACCESS_TOKEN_NAME = "access_token";

    public static volatile String SIGN_METHOD_NAME = "sign_method";
    
    public static volatile String TRACE_ID = "trace_id";
    
    public static volatile String LOCALE_NAME = "locale";
    
    public static volatile Set<String> SYSTEM_PARAM_NAMES = new HashSet<String>();

}
