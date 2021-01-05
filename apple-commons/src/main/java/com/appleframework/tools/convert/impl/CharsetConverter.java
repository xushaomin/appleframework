package com.appleframework.tools.convert.impl;

import java.nio.charset.Charset;

import com.appleframework.tools.convert.AbstractConverter;
import com.appleframework.tools.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author cruise.xu
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{
	private static final long serialVersionUID = 1L;

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
