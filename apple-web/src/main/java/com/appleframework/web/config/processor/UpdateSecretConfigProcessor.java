package com.appleframework.web.config.processor;

import com.appleframework.web.ApiContext;
import com.appleframework.web.bean.Consts;
import com.appleframework.web.config.ConfigClient;
import com.appleframework.web.config.NettyOpt;
import io.netty.channel.Channel;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 更新秘钥配置
 * @author tanghc
 */
public class UpdateSecretConfigProcessor extends AbstractNettyProcessorNoLock {

    public UpdateSecretConfigProcessor(ConfigClient configClient, NettyOpt nettyOpt) {
        super(configClient, nettyOpt);
    }

    @Override
    protected void doProcess(Channel channel, String data) {
        logger.info("配置中心推送秘钥设置");
        try {
            String localConfigFile = ApiContext.getApiConfig().getLocalSecretConfigFile();
            FileUtils.write(new File(localConfigFile), data, Consts.UTF8);
            this.configClient.getAppSecretManager().loadSecretCache(data);
        } catch (IOException e) {
            logger.error("配置中心推送秘钥写文件失败", e);
        }
    }

}
