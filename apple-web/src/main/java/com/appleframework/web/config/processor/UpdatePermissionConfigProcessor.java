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
 * 更新权限配置
 * @author tanghc
 */
public class UpdatePermissionConfigProcessor extends AbstractNettyProcessorNoLock {

    public UpdatePermissionConfigProcessor(ConfigClient configClient, NettyOpt nettyOpt) {
        super(configClient, nettyOpt);
    }

    @Override
    protected void doProcess(Channel channel, String data) {
        logger.info("配置中心推送权限设置");
        try {
            String localConfigFile = ApiContext.getApiConfig().getLocalPermissionConfigFile();
            FileUtils.write(new File(localConfigFile), data, Consts.UTF8);
            this.configClient.getPermissionManager().loadPermissionCache(data);
        } catch (IOException e) {
            logger.error("配置中心推送权限写文件失败", e);
        }
    }

}
