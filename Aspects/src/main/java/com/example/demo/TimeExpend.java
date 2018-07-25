package com.example.demo;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yubo
 * @version V2.0
 * @Description:
 * @date 2018/6/21 上午11:19
 * @Company: cecsm.com
 * @Copyright Copyright (c) 2017
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TimeExpend {
    String  timeExpend()  default "";
}
