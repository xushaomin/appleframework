package com.appleframework.tools.convert.impl;

import com.appleframework.tools.convert.AbstractConverter;
import com.appleframework.tools.util.BooleanUtil;

/**
 * 波尔转换器
 * @author cruise.xu
 *
 */
public class BooleanConverter extends AbstractConverter<Boolean>{
	private static final long serialVersionUID = 1L;

	@Override
	protected Boolean convertInternal(Object value) {
		//Object不可能出现Primitive类型，故忽略
		return BooleanUtil.toBoolean(convertToStr(value));
	}

}
