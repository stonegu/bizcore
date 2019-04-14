package com.bizislife.core.utils;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/*
 * any method has this annotation can be accessible only by users under realm BIZ
*/
@Retention(RUNTIME)
@Target(METHOD)
public @interface BizAccess {

}
