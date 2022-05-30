package com.yijian.javabase.base;

import lombok.SneakyThrows;

import java.io.InputStream;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/21 14:50
 * @description:
 */
public class RuntimeDemo {

    @SneakyThrows
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
        Process process = runtime.exec("ipconfig");
        InputStream inputStream = process.getInputStream();
        byte[] arr = new byte[1024 * 1024 * 100];
        int b = inputStream.read(arr);
        System.out.println(new String(arr, 0, b, "gbk"));
    }

}
