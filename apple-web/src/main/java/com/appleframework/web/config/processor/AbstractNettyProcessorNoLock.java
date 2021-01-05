package com.appleframework.web.config.processor;

import com.appleframework.web.config.ConfigClient;
import com.appleframework.web.config.NettyOpt;

/**
 * @author tanghc
 */
public abstract class AbstractNettyProcessorNoLock extends AbstractNettyProcessor {

    public AbstractNettyProcessorNoLock(ConfigClient configClient, NettyOpt nettyOpt) {
        super(configClient, nettyOpt);
    }

    @Override
    protected final boolean hasLock() {
        return false;
    }
}
