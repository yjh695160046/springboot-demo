package com.yijian.order.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(value = "account-service", url = "127.0.0.1:1080")
public interface AccountServiceFeignClient {

    @PostMapping("/account/deductAccount")
    Object updateAccount(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money);
}
