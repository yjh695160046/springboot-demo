package com.yijian.javabase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author: yaojinhua
 * @date: 2021/6/30 14:41
 * @description: 创建线程的第三种方式
 */
public class CallableDemo {
    public static void main(String[] args)  {
        Callable<String> callable = new Callable<String>() {

            @Override
            public String call() throws Exception {
                for (int i = 0; i < 5; i++) {

                    System.out.println(Thread.currentThread().getName() + " :" + i);
                }
                return "null";
            }
        };
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            System.out.println(executorService.submit(callable).get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
