package com.yijian.mybatis.service.impl;

import com.yijian.mybatis.entity.User;
import com.yijian.mybatis.mapper.UserMapper;
import com.yijian.mybatis.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author: yxyaojinhua
 * @date: 2021/8/17 11:31
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OrderServiceImpl orderService;

    @Override
    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public  User  selectUserById(Long id) throws Exception {

//        userMapper.selectByUserName("yaojinhua");
//        if (id == 1){
//            //  Exception是检查异常 必须要抛出让上层处理
//            throw new Exception("Exception异常，事务是否回滚");
//        }
//        if (id == 2){
//            throw new CustomerRunTimeException("RunTimeException异常，事务是否回滚");
//        }
//        orderService.otherClassMethod();
        userMapper.deleteById(1L);
        System.out.println(userMapper.list().size());
        method1(id);
//        orderService.otherClassMethod();
        System.out.println(userMapper.list().size());
        return userMapper.selectById(id);
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method1(long id){
//        userMapper.deleteById(id);
        int i = 1 / 0;
    }
    @Transactional(rollbackFor = Exception.class)
    public void thisClassTransactionalMethod(){
        int i = 1 / 0;
    }
    /**
     * 本类中的私有方法，异常会回滚
     */
    private void thisClassPrivateMethod() {
        int i = 1 / 0;
    }


    @Override
    public User updateUserById(Long id) {
        userMapper.updateUserById(id);
        return userMapper.selectById(id);
    }
}
