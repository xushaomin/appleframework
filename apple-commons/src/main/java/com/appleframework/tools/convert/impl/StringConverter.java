package com.appleframework.tools.convert.impl;

import com.appleframework.tools.convert.AbstractConverter;

/**
 * 字符串转换器
 * @author cruise.xu
 *
 */
public class StringConverter extends AbstractConverter<String>{
	private static final long serialVersionUID = 1L;

	@Override
	protected String convertInternal(Object value) {
		return convertToStr(value);
	}

}
