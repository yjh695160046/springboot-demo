package com.yijian.demospringbootstarter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/2 10:37
 * @Description: 是否加载demo-starter的开关
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableAutoConfigTest {

}
