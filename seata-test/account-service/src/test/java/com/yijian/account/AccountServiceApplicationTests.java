package com.yijian.account;

import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.yijian.account.mapper.AccountMapper;
import com.yijian.account.entity.Account;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import javax.annotation.Resource;
import java.math.BigDecimal;

@MybatisPlusTest
public class AccountServiceApplicationTests {

    @Resource
    private AccountMapper accountMapper;

    @Test
    void testInsert() {
        Account account = new Account();
        account.setMoney(new BigDecimal(1));
        account.setUserId("1122");
        accountMapper.insert(account);
        assertThat(account.getId()).isNotNull();
    }
}
