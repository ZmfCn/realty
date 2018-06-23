package com.zmf.realty.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zmf
 * @description flag for methods who needs to decrypt the first parameter as id
 * @timestamp 2018-06-15 11:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IdDecryption {
}
