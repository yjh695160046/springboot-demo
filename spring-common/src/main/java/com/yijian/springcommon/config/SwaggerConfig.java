package com.yijian.springcommon.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: yxyaojinhua
 * @date: 2021/7/26 19:32
 * @description: Swagger配置
 */
@Configuration
@EnableSwagger2 //开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(webApiInfo())
                .groupName("webApi").select()
                .paths(Predicates.and(PathSelectors.regex("/hello/.*")))
                .build();
    }

    @Bean
    public Docket adminpiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiConfig())
                .groupName("adminApi").select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")::apply))
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("springboot webApiConfig 测试")
                .description("springboot webApiConfig 测试")
                .version("1.0")
                .contact(new Contact("yxyaojinhua", "http://yixin.com", "695160046@qq.com"))
                .build();

    }

    private ApiInfo adminApiConfig() {
        return new ApiInfoBuilder()
                .title("springboot adminApiConfig 测试")
                .description("springboot adminApiConfig 测试")
                .version("1.0")
                .contact(new Contact("yxyaojinhua", "http://yixin.com", "695160046@qq.com"))
                .build();

    }
}
