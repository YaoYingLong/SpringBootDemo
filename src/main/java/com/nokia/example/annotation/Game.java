package com.nokia.example.annotation;

import java.lang.annotation.*;

/**
 * @author by YingLong on 2020/10/26
 */
@Documented
@Repeatable(People.class)
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Game {
    String value() default "";
}
