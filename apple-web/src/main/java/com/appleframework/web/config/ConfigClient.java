package com.appleframework.web.config;

import com.appleframework.web.ApiConfig;
import com.appleframework.web.ApiContext;
import com.appleframework.web.LocalAppSecretManager;
import com.appleframework.web.ManagerInitializer;
import com.appleframework.web.config.processor.AbstractNettyProcessor;
import com.appleframework.web.config.processor.DownloadLimitConfigProcessor;
import com.appleframework.web.config.processor.DownloadPermissionConfigProcessor;
import com.appleframework.web.config.processor.DownloadSecretConfigProcessor;
import com.appleframework.web.config.processor.UpdateLimitConfigProcessor;
import com.appleframework.web.config.processor.UpdatePermissionConfigProcessor;
import com.appleframework.web.config.processor.UpdateSecretConfigProcessor;
import com.appleframework.web.limit.ApiLimitLocalManager;
import com.appleframework.web.limit.LimitConfigManager;
import com.appleframework.web.limit.LimitManager;
import com.appleframework.web.permission.ApiPermissionManager;
import com.appleframework.web.permission.PermissionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 配置客户端
 * @author tanghc
 */
public class ConfigClient {
    protected static Logger logger = LoggerFactory.getLogger(ConfigClient.class);

    private Map<String, NettyProcessor> processorMap = new HashMap<>();

    private List<ManagerInitializer> initializers = new ArrayList<>(4);

    private LimitManager limitManager = new ApiLimitLocalManager();
    private LimitConfigManager limitConfigManager;
    private PermissionManager permissionManager = new ApiPermissionManager();
    private LocalAppSecretManager appSecretManager = new LocalAppSecretManager();

    private String host;
    private int port;
    private String docUrl;


    /**
     * @param appName 应用名称
     * @param host    配置中心ip
     * @param port    配置中心端口
     */
    public ConfigClient(String appName, String host, int port) {
        ApiContext.getApiConfig().setAppName(appName);
        this.host = host;
        this.port = port;
    }

    /**
     * @param appName 应用名称
     * @param host    配置中心ip
     * @param port    配置中心端口
     * @param docUrl    本机服务器端口号
     */
    public ConfigClient(String appName, String host, int port, String docUrl) {
        this(appName, host, port);
        this.docUrl = docUrl;
    }

    public void init() {
        this.initProcessor();

        if (this.limitManager != null) {
            this.limitConfigManager = this.limitManager.getLimitConfigManager();
        }

        this.addInitializer(this.limitConfigManager);
        this.addInitializer(this.permissionManager);
        this.addInitializer(this.appSecretManager);

        ApiConfig apiConfig = ApiContext.getApiConfig();

        apiConfig.setAppSecretManager(this.appSecretManager);
        apiConfig.setLimitManager(this.limitManager);
        apiConfig.setLimitConfigManager(this.limitConfigManager);
        apiConfig.setPermissionManager(this.permissionManager);

        // 启动netty客户端
        final CountDownLatch latch = CountDownLatchManager.initCountDownLatch(AbstractNettyProcessor.getLockObjectCount());
        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                // 捕获线程中的异常
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        logger.error("Netty客户端启动失败", e);
                        System.exit(0);
                    }
                });
                return t;
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                new NettyClient(ConfigClient.this, host, port).run();
            }
        });
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.error("latch cased InterruptedException", e);
            Thread.currentThread().interrupt();
        }
    }

    public void initProcessor() {
        this.addProcessor(new DownloadLimitConfigProcessor(this, NettyOpt.DOWNLOAD_LIMIT_CONFIG));
        this.addProcessor(new DownloadPermissionConfigProcessor(this, NettyOpt.DOWNLOAD_PERMISSION_CONFIG));
        this.addProcessor(new DownloadSecretConfigProcessor(this, NettyOpt.DOWNLOAD_SECRET_CONFIG));
        this.addProcessor(new UpdateLimitConfigProcessor(this, NettyOpt.UPDATE_LIMIT_CONFIG));
        this.addProcessor(new UpdatePermissionConfigProcessor(this, NettyOpt.UPDATE_PERMISSION_CONFIG));
        this.addProcessor(new UpdateSecretConfigProcessor(this, NettyOpt.UPDATE_SECRET_CONFIG));
    }

    private void addProcessor(AbstractNettyProcessor nettyProcessor) {
        processorMap.put(nettyProcessor.getCode(), nettyProcessor);
    }


    public void addInitializer(ManagerInitializer initializer) {
        if (initializer != null) {
            this.initializers.add(initializer);
        }
    }


    public LimitConfigManager getLimitConfigManager() {
        return limitConfigManager;
    }

    public void setLimitConfigManager(LimitConfigManager limitConfigManager) {
        this.limitConfigManager = limitConfigManager;
    }

    public LimitManager getLimitManager() {
        return limitManager;
    }

    public void setLimitManager(LimitManager limitManager) {
        this.limitManager = limitManager;
    }

    public PermissionManager getPermissionManager() {
        return permissionManager;
    }

    public void setPermissionManager(PermissionManager permissionManager) {
        this.permissionManager = permissionManager;
    }

    public LocalAppSecretManager getAppSecretManager() {
        return appSecretManager;
    }

    public Map<String, NettyProcessor> getProcessorMap() {
        return processorMap;
    }

    public List<ManagerInitializer> getInitializers() {
        return initializers;
    }

    public String getLocalServerPort() {
        return docUrl;
    }
}
