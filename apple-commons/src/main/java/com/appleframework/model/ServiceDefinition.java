package com.appleframework.model;

import java.io.Serializable;

public class ServiceDefinition implements Serializable {
	
	public static String SOURCE_PROVIDER = "provider";
	public static String SOURCE_CONSUMER = "consumer";
	public static String SOURCE_EASYOPEN = "easyopen";

	private static final long serialVersionUID = 1L;

	/** 服务来源 easyopen, provider，consumer */
    private String source = "consumer";
    
	/** 应用的APPID */
    private String appId;

    /** 接口名或服务名 */
    private String name;
    
    /** 版本号 */
    private String version;
    
    /** 接口描述 */
    private String description;
    
    /** 模块名 */
    private String moduleName;
    

    public String getNameVersion() {
        return this.name + this.version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
