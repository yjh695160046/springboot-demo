package com.yijian.kafka;

import com.yijian.demospringbootstarter.EnableAutoConfigTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@SpringBootApplication
@EnableAutoConfigTest
public class KafkaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaDemoApplication.class, args);
    }


    /**
     * 配置JAAS配置文件（kafka的认证账户信息）
     */
    static {
        String config = null;
        try {
            config = ResourceUtils.getFile("classpath:kafka_client_jaas.conf").getAbsolutePath();
        } catch (FileNotFoundException e) {
            System.out.println("KAFKA SASL/PLAIN身份验证错误" + e);
        }
        if (config != null) {
            System.setProperty("java.security.auth.login.config", config);
        }
    }
}
