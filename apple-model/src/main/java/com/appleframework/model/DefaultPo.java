package com.appleframework.model;

import java.io.Serializable;

/**
 * 实体对象<br>
 * 每一个实体对象对应一张数据库表结构,表字段分别和实体对象属性一一对应<br>
 * <b>注意：实体对象类只允许由平台的代码生成工具生成,不允许手工改动
 * @author xusm
 * @since 2011-05-03
 * @see java.io.Serializable
 */
public abstract class DefaultPo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 获取主键或强制非空键值组合
     */
    public abstract Key getPk();

}
