package com.summer.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: Renp
 * @Date: 2022/05/16 22:40
 */
@Configuration
public class SwaggerConfig {

    @Bean
    Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.summer.swagger.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(
                        new ApiInfoBuilder()
                                .description("summer 项目接口文档")
                                .contact(new Contact("summer", "http://baidu.com", "summer@qq.com"))
                                .version("v1.0")
                                .title("API 测试文档")
                                .license("Apache2.0")
                                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")

                        .build()
                );
    }
}
