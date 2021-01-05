package com.appleframework.tools.convert.impl;

import com.appleframework.tools.convert.AbstractConverter;

import java.util.Optional;

/**
 * 
 * {@link Optional}对象转换器
 * 
 * @author cruise.xu
 * @since 5.0.0
 */
public class OptionalConverter extends AbstractConverter<Optional<?>> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Optional<?> convertInternal(Object value) {
		return Optional.ofNullable(value);
	}

}
