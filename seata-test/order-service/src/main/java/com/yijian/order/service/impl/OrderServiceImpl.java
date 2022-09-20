package com.yijian.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijian.order.entity.Order;
import com.yijian.order.fegin.AccountServiceFeignClient;
import com.yijian.order.fegin.StockServiceFeignClient;
import com.yijian.order.mapper.OrderMapper;
import com.yijian.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private AccountServiceFeignClient accountServiceFeignClient;

    @Resource
    private StockServiceFeignClient stockServiceFeignClient;

    @Override
    @GlobalTransactional
    public void createOrder(String userId, String commodityCode, Integer count) {
        // 创建订单
        Order order = new Order();
        order.setCount(count);
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        order.setMoney(orderMoney);
        this.baseMapper.insert(order);

        // 扣减库存
        stockServiceFeignClient.deductStock(commodityCode, count);
        // 扣减用户账号余额
        accountServiceFeignClient.updateAccount(userId, orderMoney);

    }
}
