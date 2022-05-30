package com.yijian.mybatis.service;

import com.yijian.mybatis.entity.User;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/17 11:30
 * @description:
 */
public interface UserService {

    User selectUserById(Long id) throws Exception;

    User updateUserById(Long id);
}
