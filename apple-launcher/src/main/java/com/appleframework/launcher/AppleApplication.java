package com.appleframework.launcher;

import com.appleframework.launcher.constants.AppConstant;
import com.appleframework.launcher.service.LauncherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.*;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;

/**
 * <p>
 * 脚手架通用启动器，解决服务名以及环境变量问题
 * </p>
 *
 * @package: com.appleframework.launcher
 * @description: 脚手架通用启动器，解决服务名以及环境变量问题
 */
public class AppleApplication {
	
	private static Logger log = LoggerFactory.getLogger(AppleApplication.class);

    /**
     * 创建Spring上下文
     * java -jar app.jar --spring.profiles.active=prod --server.port=2333
     *
     * @param appName 服务名
     * @param source  Application类
     * @return 创建一个当前环境的Spring上下文
     */
    public static ConfigurableApplicationContext run(String appName, Class<?> source, String... args) {
    	Version.printVersion();
    	SpringApplicationBuilder builder = createSpringApplicationBuilder(appName, source, args);
        return builder.run(args);
    }

    public static SpringApplicationBuilder createSpringApplicationBuilder(String appId, Class<?> source, String... args) {
        Assert.hasText(appId, "[APPID]应用ID不能为空");
        // 读取环境变量，使用spring boot的规则
        ConfigurableEnvironment environment = new StandardEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        propertySources.addFirst(new SimpleCommandLinePropertySource(args));
        propertySources.addLast(new MapPropertySource(StandardEnvironment.SYSTEM_PROPERTIES_PROPERTY_SOURCE_NAME, environment.getSystemProperties()));
        propertySources.addLast(new SystemEnvironmentPropertySource(StandardEnvironment.SYSTEM_ENVIRONMENT_PROPERTY_SOURCE_NAME, environment.getSystemEnvironment()));
        // 获取配置的环境变量
        String[] activeProfiles = environment.getActiveProfiles();
        if(activeProfiles.length == 0) {
        	String env = System.getProperty("app.env");
        	if(null != env) {
        		activeProfiles = new String[1];
        		activeProfiles[0] = env;
        	}
        }
        // 判断环境:dev、stg、pre、gra、prd
        List<String> profiles = Arrays.asList(activeProfiles);
        // 预设的环境
        List<String> presetProfiles = new ArrayList<>(Arrays.asList(
        		AppConstant.DEV_CODE, 
        		AppConstant.STG_CODE,
        		AppConstant.PRE_CODE,
        		AppConstant.GRA_CODE,
        		AppConstant.PRD_CODE
        	)
        );
        // 交集
        presetProfiles.retainAll(profiles);
        // 当前使用
        List<String> activeProfileList = new ArrayList<>(profiles);
        
        Function<Object[], String> joinFun = StringUtils::arrayToCommaDelimitedString;
        SpringApplicationBuilder builder = new SpringApplicationBuilder(source);
        String profile;
        if (activeProfileList.isEmpty()) {
            // 默认dev开发
            profile = AppConstant.DEV_CODE;
            activeProfileList.add(profile);
            builder.profiles(profile);
        } else if (activeProfileList.size() == 1) {
            profile = activeProfileList.get(0);
        } else {
            // 同时存在dev、stg、pre、gra、prd环境时
            throw new RuntimeException("同时存在环境变量:[" + StringUtils.arrayToCommaDelimitedString(activeProfiles) + "]");
        }
        String appleAppId = System.getProperty("app.id");
        if(null != appleAppId) {
        	appId = appleAppId;
        }
        
        String startJarPath = AppleApplication.class.getResource("/").getPath().split("!")[0];
        String activePros = joinFun.apply(activeProfileList.toArray());
        log.info("The launcher is start and the env is :[{}]，loading jar or classes is :[{}]----", activePros, startJarPath);
        Properties props = System.getProperties();
        props.setProperty("spring.application.name", appId);
        props.setProperty("spring.profiles.active", profile);
        props.setProperty("spring.banner.location", "classpath:apple_banner.txt");
        props.setProperty("app.id", appId); 
        props.setProperty("app.env", profile);
        props.setProperty("app.is-local", String.valueOf(isLocalDev()));
        props.setProperty("app.dev-mode", profile.equals(AppConstant.PRD_CODE) ? "false" : "true");
        String version = Version.version();
        if(null != version) {
            props.setProperty("app.version", version);
        }
        // 加载自定义组件
        ServiceLoader<LauncherService> loader = ServiceLoader.load(LauncherService.class);
        // 启动组件
        String sysAppI = appId;
        loader.forEach(launcherService -> launcherService.launcher(builder, sysAppI, profile, isLocalDev()));
        return builder;
    }

    /**
     * 判断是否为本地开发环境
     *
     * @return boolean
     */
    public static boolean isLocalDev() {
        String osName = System.getProperty("os.name");
        return StringUtils.hasText(osName) && !(AppConstant.OS_NAME_LINUX.equals(osName.toUpperCase()));
    }
}
