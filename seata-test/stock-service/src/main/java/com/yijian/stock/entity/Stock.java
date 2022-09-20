package com.yijian.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("stock_tbl")
public class Stock {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String commodityCode;
    private Integer count;

}
