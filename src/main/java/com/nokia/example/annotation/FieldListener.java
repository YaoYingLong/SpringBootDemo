package com.nokia.example.annotation;

import java.lang.annotation.*;

/**
 * @author by YingLong on 2020/10/26
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface FieldListener {
    String value();
}
