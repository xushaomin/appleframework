package com.appleframework.tools.convert.impl;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

import com.appleframework.tools.convert.AbstractConverter;
import com.appleframework.tools.convert.ConverterRegistry;
import com.appleframework.tools.util.TypeUtil;

/**
 * {@link AtomicReference}转换器
 * 
 * @author cruise.xu
 * @since 3.0.8
 */
@SuppressWarnings("rawtypes")
public class AtomicReferenceConverter extends AbstractConverter<AtomicReference> {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected AtomicReference<?> convertInternal(Object value) {
		
		//尝试将值转换为Reference泛型的类型
		Object targetValue = null;
		final Type paramType = TypeUtil.getTypeArgument(AtomicReference.class);
		if(false == TypeUtil.isUnknow(paramType)){
			targetValue = ConverterRegistry.getInstance().convert(paramType, value);
		}
		if(null == targetValue){
			targetValue = value;
		}
		
		return new AtomicReference<>(targetValue);
	}

}
