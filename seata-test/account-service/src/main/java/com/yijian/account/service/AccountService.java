package com.yijian.account.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yijian.account.entity.Account;

import java.math.BigDecimal;

public interface AccountService extends IService<Account> {

    void deductAccount(String userId, BigDecimal num);
}
