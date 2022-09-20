package com.yijian.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("account_tbl")
public class Account {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String userId;
    private BigDecimal money;
}
