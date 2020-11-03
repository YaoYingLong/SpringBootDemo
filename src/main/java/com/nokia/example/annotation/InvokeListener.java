package com.nokia.example.annotation;

import java.lang.annotation.*;

/**
 * @author by YingLong on 2020/10/26
 */
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface InvokeListener {
    String name() default "baseService";
    int weight() default 25;
}
