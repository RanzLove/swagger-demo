package com.ranz.swagger.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.ApiSelector;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @program: springboot-swagger
 * @description:
 * @author: J.Flying
 * @create: 2020-11-02 11:27
 */

@Configuration
@EnableSwagger2
@ConfigurationProperties
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean flag;

    /**
    * @Description: 实现多个分组
    * @Author: J.Flying
    * @Date: 2020/11/2
    */
    @Bean
    public Docket a(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    /** 
    * @Description: 配置swagger 的docket 的bean 实例 
    * @Author: J.Flying 
    * @Date: 2020/11/2 
    */ 
    @Bean
    public Docket docket(){
        System.out.println(flag);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("ranzy-api")
                .enable(flag)
                .select()
         //        RequestHandlerSelectors 配置扫描接口方式
//                .apis(RequestHandlerSelectors.basePackage("com.ranz.swagger.controller"))//指定扫描的包
                .apis(RequestHandlerSelectors.any())//全部扫描的包
//                .apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))//指定扫描的注解
//                .apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                .build();
    }


    /** 
    * @Description: 配置swagger-api  的基本信息
    * @Author: J.Flying 
    * @Date: 2020/11/2 
    */ 
    public ApiInfo apiInfo(){

        return new ApiInfo("ranzy api",
                "test ranzy",
                "1.0",
                "urn:tos",
                 new Contact("ranzy","http://106.15.42.100:6679/",""),
                "Apache 2.0",
                "http://106.15.42.100:6679/",
                new ArrayList());

    }

}
