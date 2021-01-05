package com.appleframework.model;

/**
 * 非空数据传输对象接口<br>
 * @author Cruise.Xu
 * @since 2011-05-03
 * @see cn.wondershare.cmsframework.core.datastructure.Dto
 */
public interface Key extends Dto {
	/**
	 * 对Key数据传输对象进行键值非空性校验
	 * @throws Exception 
	 */
	public void validateNullAble();
}
