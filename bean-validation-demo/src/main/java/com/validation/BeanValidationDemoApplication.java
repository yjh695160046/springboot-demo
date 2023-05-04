package com.validation;

import com.yijian.demospringbootstarter.EnableAutoConfigTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yaojinhua
 */
@EnableAutoConfigTest
@SpringBootApplication
public class BeanValidationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeanValidationDemoApplication.class, args);
    }

}
