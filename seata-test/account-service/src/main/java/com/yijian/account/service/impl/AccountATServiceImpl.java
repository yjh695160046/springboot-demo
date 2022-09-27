package com.yijian.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yijian.account.entity.Account;
import com.yijian.account.mapper.AccountMapper;
import com.yijian.account.service.AccountATService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountATServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountATService {
    private static final String ERROR_USER_ID = "1002";

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deductAccount(String userId, BigDecimal num) {
        LambdaQueryWrapper<Account> eq = new LambdaQueryWrapper<Account>()
                .eq(Account::getUserId, userId);
        Account account = this.baseMapper.selectOne(eq);
        account.setMoney(account.getMoney().subtract(num));
        this.baseMapper.updateById(account);
        if (ERROR_USER_ID.equals(userId)) {
            throw new RuntimeException("account branch exception");
        }
    }
}
