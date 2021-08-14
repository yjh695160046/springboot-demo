package com.yijian.springcommon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yaojinhua
 *    统一异常处理 统一返回值 统一日志管理 引入swagger2-ui
 */
@SpringBootApplication
public class SpringCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCommonApplication.class, args);
    }

}
