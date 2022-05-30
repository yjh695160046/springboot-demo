package com.yijian.mybatis.Exception;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/4 17:06
 * @description:
 */
public class CustomerRunTimeException extends RuntimeException{

    private static final long serialVersionUID = 4260728700761970799L;


    public CustomerRunTimeException(String message) {
        super(message);
    }
}
