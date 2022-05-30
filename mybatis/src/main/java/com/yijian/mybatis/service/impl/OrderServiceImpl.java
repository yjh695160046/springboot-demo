package com.yijian.mybatis.service.impl;

import com.yijian.mybatis.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/6 15:49
 * @description:
 */
@Service
public class OrderServiceImpl {
    @Resource
    private UserMapper userMapper;
@Transactional(propagation = Propagation.REQUIRES_NEW)
    public void otherClassMethod() {
        userMapper.deleteById(1L);
    }
}
