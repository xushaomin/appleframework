package com.appleframework.launcher.constants;

/**
 * <p>
 * 系统常量
 * </p>
 *
 * @package: com.appleframework.launcher.constants
 * @description: 系统常量
 * @author: cruise.xu
 */
public interface AppConstant {
	
    /**
     * 开发环境
     */
    String DEV_CODE = "dev";
    /**
     * 生产环境
     */
    String PRD_CODE = "prd";
    
    /**
     * 测试环境
     */
    String STG_CODE = "stg";
    
    /**
     * 灰度环境
     */
    String GRA_CODE = "gra";
    
    /**
     * 预发布环境
     */
    String PRE_CODE = "pre";
    
    /**
     * 代码部署于 linux 上，工作默认为 Mac 和 Windows
     */
    String OS_NAME_LINUX = "LINUX";
    
}
