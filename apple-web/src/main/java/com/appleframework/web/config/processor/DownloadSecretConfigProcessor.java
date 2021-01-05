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
 * 下载秘钥配置
 * @author tanghc
 */
public class DownloadSecretConfigProcessor extends AbstractNettyProcessor {

    public DownloadSecretConfigProcessor(ConfigClient configClient, NettyOpt nettyOpt) {
        super(configClient, nettyOpt);
    }

    @Override
    protected void doProcess(Channel channel, String data) {
        try {
            String localConfigFile = ApiContext.getApiConfig().getLocalSecretConfigFile();
            FileUtils.write(new File(localConfigFile), data, Consts.UTF8);
            logger.info("秘钥配置下载成功，保存路径：{}", localConfigFile);
            this.configClient.getAppSecretManager().loadSecretCache(data);
        } catch (IOException e) {
            logger.error("秘钥配置下载失败", e);
        }
    }

}
