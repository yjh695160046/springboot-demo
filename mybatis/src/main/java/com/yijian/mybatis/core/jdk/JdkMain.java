package com.yijian.mybatis.core.jdk;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author: yxyaojinhua
 * @date: 2022/3/10 16:12
 * @description:
 */
public class JdkMain {
    public static void main(String[] args) throws Exception {
        SmsService proxy = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
//        proxy.send();
        //通过反编译工具可以查看源代码
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{SmsService.class});
        FileOutputStream os = new FileOutputStream("D://$Proxy0.class");
        os.write(bytes);

    }
}
