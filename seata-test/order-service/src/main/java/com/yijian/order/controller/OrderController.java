package com.yijian.order.controller;

import com.yijian.order.pojo.common.BaseResponse;
import com.yijian.order.service.OrderATService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderATService orderATService;
    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @PostMapping("/create/commit")
    public Object createOrder(String userId, String commodityCode, Integer count){
        orderATService.createOrder("1001", "2001", 1);
        return BaseResponse.success(true);
    }

    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @PostMapping("/create/rollback")
    public Object createOrderRollback(String userId, String commodityCode, Integer count){
        orderATService.createOrder("1002", "2001", 1);
        return BaseResponse.success(true);
    }

    /**
     * 模拟不加seata 会不会回滚
     * @param userId
     * @param commodityCode
     * @param count
     * @return
     */
    @PostMapping("/create/no-seata-rollback")
    public Object createOrderNoSeata(String userId, String commodityCode, Integer count){
        orderATService.createOrderNoSeata("1002", "2001", 1);
        return BaseResponse.success(true);
    }


}
