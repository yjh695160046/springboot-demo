package com.yijian.javabase.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: yxyaojinhua
 * @date: 2021/9/26 14:45
 * @description:
 */
public class CompletableFutureTest {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("main...start...");

        CompletableFuture<Integer> completableFuture01 = CompletableFuture.supplyAsync(() -> {
            //使用sleep()模拟耗时操作
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        CompletableFuture<Integer> completableFuture02 = CompletableFuture.supplyAsync(() -> {
            //使用sleep()模拟耗时操作
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });
        CompletableFuture.allOf(completableFuture01, completableFuture02);
        System.out.println(completableFuture01.join() + completableFuture02.join());
        System.out.println("main...end...");
    }


}
