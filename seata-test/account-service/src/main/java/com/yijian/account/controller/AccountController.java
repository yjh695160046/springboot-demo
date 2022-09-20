package com.yijian.account.controller;

import com.yijian.account.pojo.common.BaseResponse;
import com.yijian.account.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountService accountService;

    @PostMapping("/deductAccount")
    public Object updateAccount(@RequestParam("userId") String userId, @RequestParam("money") BigDecimal money){
        accountService.deductAccount(userId, money);
        return BaseResponse.success(true);
    }
}
