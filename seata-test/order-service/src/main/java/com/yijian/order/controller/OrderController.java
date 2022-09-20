package com.yijian.order.controller;

import com.yijian.order.pojo.common.BaseResponse;
import com.yijian.order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderService;
    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @PostMapping("/create/commit")
    public Object createOrder(String userId, String commodityCode, Integer count){
        orderService.createOrder("1001", "2001", 1);
        return BaseResponse.success(true);
    }
    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @PostMapping("/create/rollback")
    public Object createOrderRollback(String userId, String commodityCode, Integer count){
        orderService.createOrder("1002", "2001", 1);
        return BaseResponse.success(true);
    }

}
