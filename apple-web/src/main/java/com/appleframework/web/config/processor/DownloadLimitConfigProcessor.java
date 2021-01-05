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
 * 下载限流配置
 * @author tanghc
 */
public class DownloadLimitConfigProcessor extends AbstractNettyProcessor {

    public DownloadLimitConfigProcessor(ConfigClient configClient, NettyOpt nettyOpt) {
        super(configClient, nettyOpt);
    }

    @Override
    protected void doProcess(Channel channel, String data) {
        try {
            String localConfigFile = ApiContext.getApiConfig().getLocalLimitConfigFile();
            FileUtils.write(new File(localConfigFile), data, Consts.UTF8);
            logger.info("限流配置下载成功，保存路径：{}", localConfigFile);
            this.configClient.getLimitConfigManager().loadLimitCache(data);
        } catch (IOException e) {
            logger.error("限流配置下载失败", e);
        }
    }

}
