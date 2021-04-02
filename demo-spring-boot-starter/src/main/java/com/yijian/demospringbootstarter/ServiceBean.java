package com.yijian.demospringbootstarter;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/1 17:29
 * @Description:
 */
public class ServiceBean {

    public String sayHello(String name){
       return String.format("Hello World, %s", name);
    }
}
