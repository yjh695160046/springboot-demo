package com.yijian.controller;

import com.yijian.redisson.RedissonLock;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RMap;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RSemaphore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Description: 不基于注解方式锁操作
 *
 * @author xub
 * @date 2019/6/19 下午6:01
 */
@RestController
@Slf4j
public class LockController {

    @Autowired
    RedissonLock redissonLock;
    @Resource
    private Redisson redisson;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 模拟这个是商品库存
     */
    public static volatile Integer TOTAL = 10;


    @GetMapping("/lockWithWatchDog")
    public Object lockWithWatchDog() throws InterruptedException {
        redissonLock.lock("lock");
        System.out.println("开始执行业务代码了...." + Thread.currentThread().getId());
        Thread.sleep(50000);
        return "success";
    }

    /**
     * 读写锁，写锁控制读锁、写锁存在 读锁必须等待  保证一定能读到最新数据
     * 读 - 读 ==> 属于无锁状态
     * 读 - 写 ==> 写必须等待读锁释放
     * 写 - 读
     * 写 - 写
     *
     * @return
     */
    @GetMapping("readLock")
    public Object readWriteLock() throws InterruptedException {
        RReadWriteLock readWriteLock = redissonLock.readWriteLock("readWriteLock");
        String test = "";
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code" , 200);
        returnMap.put("msg" , "success");
        try {
            readWriteLock.readLock().lock();
            returnMap.put("data", stringRedisTemplate.opsForValue().get("test"));
        }finally {
            readWriteLock.readLock().unlock();
        }
        return returnMap;
    }
    /**
     * 读写锁，写锁控制读锁、写锁存在 读锁必须等待 成对出现
     * @return
     */
    @GetMapping("writeLock")
    public Object writeLock() throws InterruptedException {
        RReadWriteLock readWriteLock = redissonLock.readWriteLock("readWriteLock");
        try {
            readWriteLock.writeLock().lock();
            stringRedisTemplate.opsForValue().set("test", UUID.randomUUID().toString());
            Thread.sleep(30000);
        }finally {
            readWriteLock.writeLock().unlock();
        }
        return "success";
    }

    /**
     *  闭锁: countdownLatch
     *  模拟5个班级的都走完 才能关门走人
     */
    @GetMapping("closeDoor")
    public Object closeDoor() throws InterruptedException {
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code" , 200);
        returnMap.put("msg" , "success");

        RCountDownLatch anyCountDownLatch = redissonLock.countLatch("anyCountDownLatch");
        anyCountDownLatch.trySetCount(5); //
        anyCountDownLatch.await(); // 等待
        returnMap.put("data", "关门放假了....");
        return returnMap;
    }

    /**
     *  模拟班级下课放学
     */
    @GetMapping("/go/{id}")
    public String go(@PathVariable String id){
        RCountDownLatch anyCountDownLatch = redissonLock.countLatch("anyCountDownLatch");
        anyCountDownLatch.countDown();
        return id + "班级走了";
    }

    /**
     * 分布式信号量：
     *   模拟车位停车 : 车位3个
     * @return
     */
    @GetMapping("/pack")
    public String pack() throws InterruptedException {
        RSemaphore rSemaphore = redissonLock.semaphore("pack");
        // rSemaphore.acquire(); //获取一个信号量 占用一个车位 如果占不到会一直等待 阻塞
        rSemaphore.acquire(11); // 参数permits一次获取多少信号量
        // rSemaphore.tryAcquire(5, TimeUnit.SECONDS); // 获取一个信号 5秒钟的等待时间 时间到获取不到返回false 获取信号量失败
        return Thread.currentThread().getId() + "占用一个车位成功";
    }

    /**
     * 分布式信号量： 可以用于业务场景的限流操作  1分钟并发请求多少?  只能用一个请求进来 ?
     *   模拟车位开走
     * @return
     */
    @GetMapping("/go")
    public String go() throws InterruptedException {
        RSemaphore rSemaphore = redissonLock.semaphore("pack");
        rSemaphore.release(); // 释放一个车位
        // 真实业务逻辑 释放的车位不能大于总车位 这个地方要判断
        return Thread.currentThread().getId() + "释放一个车位成功";
    }



    // 分布式对象
    @GetMapping("/distributedObject")
    public Object distributedObject(){
        RMap<Object, Object> myMap = redisson.getMap("myMap");
        myMap.put("test", 123);
        myMap.put("test1", 123);
        myMap.put("test2", "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fpic15.nipic.com%2F20110708%2F3388327_164155701127_2.jpg&refer=http%3A%2F%2Fpic15.nipic.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1636277051&t=bb1aea14c099fb688b14c548133c20c6");
        System.out.println(myMap.getName());
        // 所有与redis keys 相关的操作 都在Rkey中
        System.out.println("keys all" + redisson.getKeys().getKeys());

        // 通用对象桶 桶可以存任意类型数据
        RBucket<Map<Object, Object>> bucket = redisson.getBucket("bucket");
        bucket.set(myMap);
        System.out.println(bucket.get().get("test1"));

        return "sucess";
    }












    @GetMapping("/getBuckets")
    public Object getBuckets(){
        RBucket bucket = redissonLock.getBucket("a");
        bucket.set("bb");
        //redissonLock.getBucket()
        if (redissonLock.getBucket("a").delete()){
            System.out.println(111);
        }
        return redissonLock.getBucket("a").isExists();
    }

    @GetMapping("lock-decrease-stock")
    public String lockDecreaseStock() throws InterruptedException {
        redissonLock.lock("lock", 10L);
        if (TOTAL > 0) {
            TOTAL--;
        }
        Thread.sleep(50);
        log.info("===lock===减完库存后,当前库存===" + TOTAL);
        //如果该线程还持有该锁，那么释放该锁。如果该线程不持有该锁，说明该线程的锁已到过期时间，自动释放锁
        if (redissonLock.isHeldByCurrentThread("lock")) {
            redissonLock.unlock("lock");
        }
        return "=================================";
    }

    @GetMapping("trylock-decrease-stock")
    public String trylockDecreaseStock() throws InterruptedException {
        if (redissonLock.tryLock("trylock", 5L, 200L)) {
            if (TOTAL > 0) {
                TOTAL--;
            }
            Thread.sleep(50);
            redissonLock.unlock("trylock");
            log.info("====tryLock===减完库存后,当前库存===" + TOTAL);
        } else {
            log.info("[ExecutorRedisson]获取锁失败");
        }
        return "===================================";
    }



}
