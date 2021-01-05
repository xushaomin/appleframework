package com.appleframework.web.config.processor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.appleframework.web.ApiContext;
import com.appleframework.web.bean.Consts;
import com.appleframework.web.config.ConfigClient;
import com.appleframework.web.config.NettyOpt;

import io.netty.channel.Channel;

/**
 * 更新限流配置
 * @author tanghc
 */
public class UpdateLimitConfigProcessor extends AbstractNettyProcessorNoLock {

    public UpdateLimitConfigProcessor(ConfigClient configClient, NettyOpt nettyOpt) {
        super(configClient, nettyOpt);
    }

    @Override
    protected void doProcess(Channel channel, String data) {
        logger.info("配置中心推送限流设置");
        try {
            String localConfigFile = ApiContext.getApiConfig().getLocalLimitConfigFile();
            FileUtils.write(new File(localConfigFile), data, Consts.UTF8);
            this.configClient.getLimitConfigManager().loadLimitCache(data);
        } catch (IOException e) {
            logger.error("配置中心推送限流写文件失败", e);
        }
    }

}
