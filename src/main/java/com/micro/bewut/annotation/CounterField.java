package com.micro.bewut.annotation;

import java.lang.annotation.*;

@Repeatable(CounterFields.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface CounterField {

    String path() default "";

    String as();

}
