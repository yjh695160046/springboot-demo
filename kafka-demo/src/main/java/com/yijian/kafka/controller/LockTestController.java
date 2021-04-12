package com.yijian.kafka.controller;

import com.yijian.kafka.config.DistributedRedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yaojinhua
 * @Date: 2021/4/7 15:06
 * @Description:
 */
@RestController
@RequestMapping("/lock")
@Slf4j
public class LockTestController {

    private final String LOCK = "LOCK";

    @Autowired
    private DistributedRedisLock distributedRedisLock;

    // 测试不释放锁
    @GetMapping("/testLock")
    public Object testLock() {
        //for (int i = 0; i < 5; i++) {
        //    new Thread(() -> {
        //        distributedRedisLock.lock(LOCK);
        //    }).start();
        //}
        distributedRedisLock.lock(LOCK);
        return "c.y.kafka.config.DistributedRedisLock";
    }

    /**
     * 实际业务开发使用分布式锁的方式
     */
    @PostMapping("/testLock")
    public Object post() {
        try {
            if (distributedRedisLock.lock(LOCK)) {
                // 业务逻辑
                log.info("开始业务逻辑");
            } else {
                // 处理获取锁失败的逻辑
                log.info("获取锁失败");
            }
        } catch (Exception e) {
            log.error("处理异常：", e);
        } finally {
            distributedRedisLock.unlock(LOCK);
        }
        return "5131";
    }
}
