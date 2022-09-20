package com.yijian.stock.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijian.stock.entity.Stock;
import com.yijian.stock.mapper.StockMapper;
import com.yijian.stock.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

    @Override
    public void deductStock(String commodityCode, Integer count) {
        Stock stock = this.baseMapper.selectOne(new LambdaQueryWrapper<Stock>()
                .eq(Stock::getCommodityCode, commodityCode));
        stock.setCount(stock.getCount() - count);
        this.baseMapper.updateById(stock);
    }
}
