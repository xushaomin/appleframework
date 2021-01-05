package com.appleframework.web;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotNull;

import org.junit.Test;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import com.appleframework.web.annotation.Api;
import com.appleframework.web.register.SingleParameterContext;
import com.appleframework.web.register.SingleParameterWrapper;
import com.appleframework.web.util.FieldUtil;

import junit.framework.TestCase;

/**
 * @author tanghc
 */
public class TypeTest extends TestCase {

    public void testDo() {
        System.out.println("Integer.class:" + Integer.class.isPrimitive());
        System.out.println("Integer.TYPE:" + Integer.TYPE.isPrimitive());
        System.out.println("int.class:" + int.class.isPrimitive());
        System.out.println( Integer.class.getGenericSuperclass() == Number.class);
    }


    public void testSimpleParamWrapper() throws Exception{
        SingleParameterWrapper wrapper = new SingleParameterWrapper();
        Api2 api2 = new Api2();
        ReflectionUtils.doWithMethods(Api2.class, new ReflectionUtils.MethodCallback() {
            @SuppressWarnings("deprecation")
			@Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                Api anno = AnnotationUtils.findAnnotation(method, Api.class);
                if (anno == null) {
                    return;
                }
                Parameter[] parameters = method.getParameters();
                Class<?> paramClass = null;
                if (parameters != null && parameters.length > 0) {
                    Parameter parameter = parameters[0];
                    paramClass = parameter.getType();
                    System.out.println(paramClass);
                    try {
                        String paramName = FieldUtil.getMethodParameterName(Api2.class, method, 0);
                        Class<?> clazz = wrapper.wrapParam(parameter, paramName);

                        SingleParameterContext.add(api2, method, parameter);

                        Object beanObj = clazz.getConstructor().newInstance();

                        Set<ConstraintViolation<Object>> ret = ApiValidator.getValidator().validate(beanObj);
                        Assert.isTrue(ret.size() > 0);

                        clazz.getField(paramName).set(beanObj, 11);

                        ret = ApiValidator.getValidator().validate(beanObj);
                        Assert.isTrue(ret.size() == 0);

                        Object val = clazz.getField(paramName).get(beanObj);
                        System.out.println("filed value : " + val);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.err.println(e);
                    }
                }
            }
        });

    }

    @Test
    public void testDo2() {
        ReflectionUtils.doWithMethods(Api2.class, new ReflectionUtils.MethodCallback() {
            @Override
            public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                if (method.getName().equals("fun")) {
                    String fun = FieldUtil.getMethodParameterName(Api2.class, method, 0);
                    System.out.println(fun);
                }
            }
        });
    }

    static class Api2{
        @Api(name = "dd")
        public void fun(@NotNull(message = "i not null") Integer i) {

        }
    }

    static class Param {
        @NotNull(message = "s不能为空")
        private String s;

        public String getS() {
            return s;
        }

        public void setS(String s) {
            this.s = s;
        }
    }

}
