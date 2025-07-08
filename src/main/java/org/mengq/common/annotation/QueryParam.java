package org.mengq.common;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface QueryParam {

    String key();

    String value();

    boolean required() default true;
}
