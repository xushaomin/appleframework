package com.appleframework.tools.convert.impl;

import java.util.concurrent.atomic.AtomicBoolean;

import com.appleframework.tools.convert.AbstractConverter;
import com.appleframework.tools.util.BooleanUtil;

/**
 * {@link AtomicBoolean}转换器
 * 
 * @author cruise.xu
 * @since 3.0.8
 */
public class AtomicBooleanConverter extends AbstractConverter<AtomicBoolean> {
	private static final long serialVersionUID = 1L;

	@Override
	protected AtomicBoolean convertInternal(Object value) {
		if (boolean.class == value.getClass()) {
			return new AtomicBoolean((boolean) value);
		}
		if (value instanceof Boolean) {
			return new AtomicBoolean((Boolean) value);
		}
		final String valueStr = convertToStr(value);
		return new AtomicBoolean(BooleanUtil.toBoolean(valueStr));
	}

}
