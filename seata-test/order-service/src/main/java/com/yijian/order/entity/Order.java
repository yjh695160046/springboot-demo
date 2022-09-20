package com.yijian.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("order_tbl")
public class Order {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userId;

    private String commodityCode;

    private BigDecimal money;

    private Integer count;
}
