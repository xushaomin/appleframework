package com.appleframework.web.serializer;

import com.alibaba.fastjson.JSON;
import com.appleframework.web.ResultSerializer;

/**
 * 序列化json
 * @author tanghc
 */
public class JsonResultSerializer implements ResultSerializer {

    @Override
    public String serialize(Object obj) {
        return JSON.toJSONString(obj);
    }

}
