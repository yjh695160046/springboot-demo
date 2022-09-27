package com.yijian.stock.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yijian.stock.entity.Stock;

public interface StockATService extends IService<Stock> {
    void deductStock(String commodityCode, Integer count);
}
