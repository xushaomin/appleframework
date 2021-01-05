package com.appleframework.web.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.appleframework.web.ApiContext;
import com.appleframework.web.ApiParam;
import com.appleframework.web.exception.DuplicateApiNameException;

/**
 * 负责存储定义好的接口信息
 * 
 * @author tanghc
 *
 */
public class DefinitionHolder {
	/** key:nameversion */
	private static Map<String, ApiDefinition> apiDefinitionMap = new ConcurrentHashMap<String, ApiDefinition>(64);

	private static volatile String defaultVersion = null;

	public static void addApiDefinition(ApiDefinition apiDefinition) throws DuplicateApiNameException {
		String key = getKey(apiDefinition);
		boolean hasApi = apiDefinitionMap.containsKey(key);
		if (hasApi) {
			throw new DuplicateApiNameException("重复申明接口,name:" + apiDefinition.getName() + " ,version:"
					+ apiDefinition.getVersion() + ",method:" + apiDefinition.getMethod().getName());

		}
		apiDefinitionMap.put(key, apiDefinition);
	}

	/**
	 * 获取全部接口
	 * 
	 * @return 返回全部解开
	 */
	public static List<Api> listAllApi() {
		Collection<ApiDefinition> allApi = apiDefinitionMap.values();
		List<Api> ret = new ArrayList<>(allApi.size());
		for (ApiDefinition apiDefinition : allApi) {
			Api api = new Api();
			api.setName(apiDefinition.getName());
			api.setVersion(apiDefinition.getVersion());
			api.setDescription(apiDefinition.getDescription());
			api.setModuleName(apiDefinition.getModuleName());
			api.setOrderIndex(apiDefinition.getOrderIndex());
			ret.add(api);
		}
		return ret;
	}

	public static Map<String, ApiDefinition> getApiDefinitionMap() {
		return apiDefinitionMap;
	}

	public static ApiDefinition getByParam(ApiParam param) {
		String key = getKey(param.fatchName(), param.fatchVersion());
		return apiDefinitionMap.get(key);
	}

	public static String getKey(ApiDefinition apiDefinition) {
		return getKey(apiDefinition.getName(), apiDefinition.getVersion());
	}

	public static String getKey(String name, String version) {
		if (version == null) {
			version = getDefaultVersion();
		}
		return name + version;
	}

	private static String getDefaultVersion() {
		if (defaultVersion == null) {
			synchronized (DefinitionHolder.class) {
				if (defaultVersion == null) {
					defaultVersion = ApiContext.getApiConfig().getDefaultVersion();
				}
			}
		}
		return defaultVersion;
	}

	public static void setApiInfo(Api api) {
		ApiDefinition apiDefinition = apiDefinitionMap.get(api.getName() + api.getVersion());
		if (apiDefinition != null) {
			apiDefinition.setDescription(api.getDescription());
			apiDefinition.setModuleName(api.getModuleName());
			apiDefinition.setOrderIndex(api.getOrderIndex());
		}
	}
	
	public static void clear() {
		apiDefinitionMap.clear();
		defaultVersion = null;
	}

}
