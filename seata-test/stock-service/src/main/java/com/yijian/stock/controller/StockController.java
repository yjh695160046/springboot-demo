package com.yijian.stock.controller;

import com.yijian.stock.pojo.common.BaseResponse;
import com.yijian.stock.service.StockATService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockATService stockATService;

    @PostMapping("/deductStock")
    public Object deductStock(@RequestParam("commodityCode") String commodityCode,
                              @RequestParam("count") Integer count){
        stockATService.deductStock(commodityCode, count);
        return BaseResponse.success(true);
    }

}
