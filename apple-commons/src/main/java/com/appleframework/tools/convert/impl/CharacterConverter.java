package com.appleframework.tools.convert.impl;

import com.appleframework.tools.convert.AbstractConverter;
import com.appleframework.tools.util.BooleanUtil;
import com.appleframework.tools.util.StrUtil;

/**
 * 字符转换器
 * 
 * @author cruise.xu
 *
 */
public class CharacterConverter extends AbstractConverter<Character> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Character convertInternal(Object value) {
		if (value instanceof Boolean) {
			return BooleanUtil.toCharacter((Boolean) value);
		} else {
			final String valueStr = convertToStr(value);
			if (StrUtil.isNotBlank(valueStr)) {
				return valueStr.charAt(0);
			}
		}
		return null;
	}

}
