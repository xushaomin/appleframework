package com.appleframework.tools.convert.impl;

import com.appleframework.tools.convert.AbstractConverter;

import java.time.Duration;
import java.time.temporal.TemporalAmount;

/**
 * 
 * {@link Duration}对象转换器
 * 
 * @author cruise.xu
 * @since 5.0.0
 */
public class DurationConverter extends AbstractConverter<Duration> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Duration convertInternal(Object value) {
		if(value instanceof TemporalAmount){
			return Duration.from((TemporalAmount) value);
		} else if(value instanceof Long){
			return Duration.ofMillis((Long) value);
		} else {
			return Duration.parse(convertToStr(value));
		}
	}

}
