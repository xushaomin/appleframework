package com.appleframework.web.doc.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author tanghc
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
public @interface ApiDocRootData {
}
