package org.mengq.common.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Inherited
public @interface QueryParam {
    String key();

    boolean required() default true;

    String defaultVal() default "";
}
