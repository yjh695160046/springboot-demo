package com.yijian.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijian.order.entity.Order;
import com.yijian.order.mapper.OrderMapper;
import com.yijian.order.service.OrderTCCService;
import com.yijian.order.service.ResultHolder;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Slf4j
@Service
public class OrderTCCServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderTCCService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean prepareCreateOrder(BusinessActionContext businessActionContext, String userId,
                                   String commodityCode, Integer count) {
        log.info("创建 order 第一阶段，预留资源 - "+businessActionContext.getXid());
        // 创建订单
        Order order = new Order();
        order.setCount(count);
        order.setCommodityCode(commodityCode);
        order.setUserId(userId);
        BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
        order.setMoney(orderMoney);
        this.baseMapper.insert(order);
        // 事务成功，保存一个标识，供第二阶段进行判断
        ResultHolder.setResult(getClass(), businessActionContext.getXid(), "p");
        return true;
    }


    @Override
    public boolean commit(BusinessActionContext context) {
        return false;
    }

    @Override
    public boolean cancel(BusinessActionContext context) {
        return false;
    }
}
