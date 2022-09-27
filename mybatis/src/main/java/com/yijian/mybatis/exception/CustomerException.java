package com.yijian.mybatis.exception;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/4 17:06
 * @description:
 */
public class CustomerException extends Exception{

    private static final long serialVersionUID = 4260728700761970799L;


    public CustomerException(String message) {
        super(message);
    }
}
