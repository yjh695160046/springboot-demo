package com.spring.code;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/31 16:08
 * @description: 5大金刚
 */
@Getter
@Setter
public class Person {

    private String name;

    private Integer age;

    public Person() {
        System.out.println("person ==> 无参构造方法被调用 对象创建成功！！！" );
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("person ==> 有参构造方法被调用 对象创建成功 同时初始化参数！！！" );
    }
}
