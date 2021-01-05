/*
 * Copyright 2019 Yangkai.Shen
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package com.appleframework.model.api;

/**
 * <p>
 * 业务代码枚举
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.api
 * @description: 业务代码枚举
 * @author: cruise.xu
 */
public enum ResultCode implements IResultCode {

	/**
	 * 操作成功
	 */
	SUCCESS(ResultStatus.SC_SUCCESS, "操作成功"),
	
    /**
     * 业务异常
     */
    FAILURE(-1, "业务异常"),
	
	/**
	 * 请求未授权
	 */
	UN_AUTHORIZED(ResultStatus.SC_UNAUTHORIZED, "请求未授权"),

	/**
	 * 404 没找到请求
	 */
	NOT_FOUND(ResultStatus.SC_NOT_FOUND, "404 没找到请求"),

	/**
	 * 消息不能读取
	 */
	MSG_NOT_READABLE(ResultStatus.SC_BAD_REQUEST, "消息不能读取"),

	/**
	 * 不支持当前请求方法
	 */
	METHOD_NOT_SUPPORTED(ResultStatus.SC_METHOD_NOT_ALLOWED, "不支持当前请求方法"),

	/**
	 * 不支持当前媒体类型
	 */
	MEDIA_TYPE_NOT_SUPPORTED(ResultStatus.SC_UNSUPPORTED_MEDIA_TYPE, "不支持当前媒体类型"),

	/**
	 * 请求被拒绝
	 */
	REQ_REJECT(ResultStatus.SC_FORBIDDEN, "请求被拒绝"),

	/**
	 * 服务器异常
	 */
	INTERNAL_SERVER_ERROR(ResultStatus.SC_INTERNAL_SERVER_ERROR, "服务器异常"),

	/**
	 * 缺少必要的请求参数
	 */
	PARAM_MISS(ResultStatus.SC_BAD_REQUEST, "缺少必要的请求参数"),

	/**
	 * 请求参数类型错误
	 */
	PARAM_TYPE_ERROR(ResultStatus.SC_BAD_REQUEST, "请求参数类型错误"),

	/**
	 * 请求参数绑定错误
	 */
	PARAM_BIND_ERROR(ResultStatus.SC_BAD_REQUEST, "请求参数绑定错误"),

	/**
	 * 参数校验失败
	 */
	PARAM_VALID_ERROR(ResultStatus.SC_BAD_REQUEST, "参数校验失败"),;

	/**
	 * code编码
	 */
	final int code;
	/**
	 * 中文信息描述
	 */
	final String msg;

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private ResultCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}
