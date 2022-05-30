package com.yijian.mybatis.mapper;

import com.yijian.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/17 11:32
 * @description:
 */
public interface UserMapper {

    List<User> list();
    User selectById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);

    User selectByUserName(@Param("userName") String userName);

    Integer updateUserById(@Param("id") Long id);
}
