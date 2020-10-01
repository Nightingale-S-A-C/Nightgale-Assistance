package com.nightingale.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Dirección para ver swagger
//http://localhost:8080/api/v1/swagger-ui.html

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nightingale.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo())
                ;
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "E-Commerce API",
                "Servicio de ventas de productos de cuidado personal para sobrellevar la pandemia",
                "1.0",
                "https://u201822001.wixsite.com/nightgale-assistance",
                new Contact("Nightingale", "http://nightingale.com", "apis@nightingale.com"),
                "LICENSE",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}