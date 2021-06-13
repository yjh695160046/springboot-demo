package com.yijian.javabase.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: yaojinhua
 * @date: 2021/5/6 11:03
 * @description:
 */
@Service
public class A {

    //public A(B b) {
    //
    //}

    @Autowired
    public B a;
}
