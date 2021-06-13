package com.yijian.javabase.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * @author: yaojinhua
 * @date: 2021/5/6 11:04
 * @description:
 */
@Service
public class B {

    //public B(A a) {
    //
    //}

    @Autowired // 不写setter() spring底层通过反射来注入
    public A a;
}
