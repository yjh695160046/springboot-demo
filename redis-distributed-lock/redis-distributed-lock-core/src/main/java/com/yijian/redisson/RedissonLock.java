package com.yijian.redisson;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RSemaphore;

import java.util.concurrent.TimeUnit;

/**
 * @author xub
 * @Description: 针对源码Redisson进行一层封装
 * @date 2019/6/19 下午10:26
 */
@Slf4j
public class RedissonLock {


    private RedissonManager redissonManager;
    private Redisson redisson;


    public RedissonLock(RedissonManager redissonManager) {
        this.redissonManager = redissonManager;
        this.redisson = redissonManager.getRedisson();
    }

    public RedissonLock() {
    }

    /**
     * 加锁操作 （设置锁的有效时间） 无看门狗机制
     *
     * @param lockName  锁名称
     * @param leaseTime 锁有效时间
     */
    public void lock(String lockName, long leaseTime) {
        RLock rLock = redisson.getLock(lockName);
        rLock.lock(leaseTime, TimeUnit.SECONDS);
    }

    /**
     * 加锁操作 (锁有效时间采用默认时间30秒，可通过配置参数lockWatchdogTimeout 来调整过期时间 但不要设置太小）
     * 未设置过期时间时，会默认开启开门狗机制【watchDog】 自动续期(延长key的过期时间)
     *  1).redisson加锁操作时会有一个定时任务【10s执行一次[lockWatchdogTimeout/3]】，如果业务代码的执行时间超过10s，会自动续期到30s
     *  2).如果未执行删除锁的操作、看门狗会一直续期
     *  3).如果当前占有锁的线程不释放锁，其他人会一直自旋等待，直到抢占锁成功 非公平锁
     *  4).在finally代码中释放锁 保证锁的正常释放
     *
     * @param lockName 锁名称
     */
    public void lock(String lockName) {
        RLock rLock = redisson.getLock(lockName);
        rLock.lock();
    }

    /**
     * 读写锁（ReadWriteLock）：
     */
    public RReadWriteLock readWriteLock(String lockName) {
        return redisson.getReadWriteLock(lockName);
    }


    /**
     * 闭锁（countDownLatch）
     */
    public RCountDownLatch countLatch(String lockName) {
        RCountDownLatch countDownLatch = redisson.getCountDownLatch(lockName);
        return countDownLatch;
    }

    /**
     * 分布式信号量（Semaphore）
     */
    public RSemaphore semaphore(String lockName) {
        RSemaphore semaphore = redisson.getSemaphore(lockName);
        return semaphore;
    }

    /**
     * 加锁操作(tryLock锁，没有等待时间）
     *
     * @param lockName  锁名称
     * @param leaseTime 锁有效时间
     */
    public boolean tryLock(String lockName, long leaseTime) {

        RLock rLock = redisson.getLock(lockName);
        boolean getLock = false;
        try {
            getLock = rLock.tryLock(leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("获取Redisson分布式锁[异常]，lockName=" + lockName, e);
            e.printStackTrace();
            return false;
        }
        return getLock;
    }

    /**
     * 加锁操作(tryLock锁，有等待时间）
     *
     * @param lockName  锁名称
     * @param leaseTime 锁有效时间
     * @param waitTime  等待时间
     */
    public boolean tryLock(String lockName, long leaseTime, long waitTime) {

        RLock rLock = redisson.getLock(lockName);
        boolean getLock = false;
        try {
            getLock = rLock.tryLock(waitTime, leaseTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("获取Redisson分布式锁[异常]，lockName=" + lockName, e);
            e.printStackTrace();
            return false;
        }
        return getLock;
    }

    /**
     * 解锁
     *
     * @param lockName 锁名称
     */
    public void unlock(String lockName) {
        redisson.getLock(lockName).unlock();
    }

    /**
     * 判断该锁是否已经被线程持有
     *
     * @param lockName 锁名称
     */
    public boolean isLock(String lockName) {
        RLock rLock = redisson.getLock(lockName);
        return rLock.isLocked();
    }


    /**
     * 判断该线程是否持有当前锁
     *
     * @param lockName 锁名称
     */
    public boolean isHeldByCurrentThread(String lockName) {
        RLock rLock = redisson.getLock(lockName);
        return rLock.isHeldByCurrentThread();
    }

    public RBucket getBucket(String name) {
        RBucket buckets = redisson.getBucket(name);
        return buckets;
    }

    public RedissonManager getRedissonManager() {
        return redissonManager;
    }

    public void setRedissonManager(RedissonManager redissonManager) {
        this.redissonManager = redissonManager;
    }
}
