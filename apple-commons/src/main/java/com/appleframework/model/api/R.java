/*
 * Copyright 2019 Yangkai.Shen
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package com.appleframework.model.api;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.lang.Nullable;

import com.appleframework.tools.util.ObjectUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 统一API响应结果封装
 * </p>
 *
 * @package: com.xkcoding.scaffold.common.api
 * @description: 统一API响应结果封装
 * @author: cruise.xu
 */
@ApiModel(description = "返回信息")
public class R<T> implements Serializable {

    private static final long serialVersionUID = -7618165659758377287L;

    @ApiModelProperty(value = "状态码", required = true)
    private int code;
        
    @ApiModelProperty(value = "返回消息", required = true)
    private String msg;
    
    @ApiModelProperty(value = "承载数据")
    private T data;

    private R(IResultCode resultCode) {
        this(resultCode, resultCode.getMsg(), null);
    }

    private R(IResultCode resultCode, String msg) {
        this(resultCode, msg, null);
    }

    private R(IResultCode resultCode, T data) {
        this(resultCode, resultCode.getMsg(), data);
    }

    private R(IResultCode resultCode, String msg, T data) {
        this.code = resultCode.getCode();
        this.msg = msg;
        this.data = data;
    }

    private R(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isSuccess(@Nullable R<?> result) {
        return Optional.ofNullable(result)
                .map(x -> ObjectUtil.equal(ResultCode.SUCCESS.code, x.code))
                .orElse(Boolean.FALSE);
    }

    /**
     * 判断返回是否为成功
     *
     * @param result Result
     * @return 是否成功
     */
    public static boolean isNotSuccess(@Nullable R<?> result) {
        return !R.isSuccess(result);
    }

    /**
     * 获取data
     *
     * @param result Result
     * @param <T>    泛型标记
     * @return 泛型对象
     */
    @Nullable
    public static <T> T getData(@Nullable R<T> result) {
        return Optional.ofNullable(result).filter(r -> isSuccess(result)).map(x -> x.getData()).orElse(null);
    }

    /**
     * 返回成功
     *
     * @param <T> 泛型标记
     * @return Result
     */
    public static <T> R<T> success() {
        return new R<>(ResultCode.SUCCESS);
    }

    /**
     * 成功-携带数据
     *
     * @param data 数据
     * @param <T>  泛型标记
     * @return Result
     */
    public static <T> R<T> success(@Nullable T data) {
        return new R<>(ResultCode.SUCCESS, data);
    }

    /**
     * 根据状态返回成功或者失败
     *
     * @param status 状态
     * @param msg    异常msg
     * @param <T>    泛型标记
     * @return Result
     */
    public static <T> R<T> status(boolean status, String msg) {
        return status ? R.success() : R.fail(msg);
    }

    /**
     * 根据状态返回成功或者失败
     *
     * @param status 状态
     * @param sCode  异常code码
     * @param <T>    泛型标记
     * @return Result
     */
    public static <T> R<T> status(boolean status, IResultCode sCode) {
        return status ? R.success() : R.fail(sCode);
    }

    /**
     * 返回失败
     *
     * @param <T> 泛型标记
     * @return Result
     */
    public static <T> R<T> fail() {
        return new R<>(ResultCode.FAILURE);
    }

    /**
     * 返回失败信息，用于 web
     *
     * @param msg 失败信息
     * @param <T> 泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(String msg) {
        return new R<>(ResultCode.FAILURE, msg);
    }

    /**
     * 返回失败信息
     *
     * @param code 状态码
     * @param msg  失败信息
     * @param <T>  泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(int code, String msg) {
        return new R<>(code, null, msg);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode) {
        return new R<>(rCode);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param msg   失败信息
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode, String msg) {
        return new R<>(rCode, msg);
    }

    /**
     * 返回失败信息
     *
     * @param rCode 异常枚举
     * @param data  数据
     * @param <T>   泛型标记
     * @return {Result}
     */
    public static <T> R<T> fail(IResultCode rCode, T data) {
        return new R<>(rCode, data);
    }

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(T data) {
		this.data = data;
	}

}
