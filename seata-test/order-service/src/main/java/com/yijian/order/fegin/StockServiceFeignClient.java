package com.yijian.order.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "stock-service", url = "127.0.0.1:3080")
public interface StockServiceFeignClient {

    @PostMapping("/stock/deductStock")
    Object deductStock(@RequestParam("commodityCode") String commodityCode,
                         @RequestParam("count") Integer count);
}
