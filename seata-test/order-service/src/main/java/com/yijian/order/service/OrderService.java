package com.yijian.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yijian.order.entity.Order;


public interface OrderService extends IService<Order> {

    void createOrder(String userId, String commodityCode, Integer count);
}
