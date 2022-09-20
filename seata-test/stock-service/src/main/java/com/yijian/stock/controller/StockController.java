package com.yijian.stock.controller;

import com.yijian.stock.pojo.common.BaseResponse;
import com.yijian.stock.service.StockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    @PostMapping("/deductStock")
    public Object deductStock(@RequestParam("commodityCode") String commodityCode,
                              @RequestParam("count") Integer count){
        stockService.deductStock(commodityCode, count);
        return BaseResponse.success(true);
    }

}
