package com.yijian.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yijian.order.entity.Order;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * TCC模式 验证seata
 */

@LocalTCC
public interface OrderTCCService extends IService<Order> {

    /**
     * 第一阶段的方法
     * 通过注解指定第二阶段的两个方法名
     * BusinessActionContext 上下文对象，用来在两个阶段之间传递数据
     *
     * @BusinessActionContextParameter 注解的参数数据会被存入 BusinessActionContext
     */
    @TwoPhaseBusinessAction(name = "orderTccAction", commitMethod = "commit", rollbackMethod = "cancel")
    boolean prepareCreateOrder(BusinessActionContext businessActionContext,
                               @BusinessActionContextParameter(paramName = "userId") String userId,
                               String commodityCode, Integer count);


    /**
     * 二阶段提交方法
     *
     * @param context 上下文
     * @return boolean
     */
    boolean commit(BusinessActionContext context);

    /**
     * 二阶段取消方法
     *
     * @param context 上下文
     * @return boolean
     */
    boolean cancel(BusinessActionContext context);

}
