package com.altimetric.tripMicroservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String SWAGGER_API_VERSION = "1.0";
    private static final String LICENCE_TEXT = "Apache LICENCE";
    private static final String TITLE = "A REST API for getting trip options";
    private static final String DESCRIPTION = "Get the fastest, cheapest and comfortable flight details";
    private static final Contact CONTACT = new Contact("Arun Magar","http://www.altimetric.com","arun.mgr1@gmail.com");
    @Bean
    public Docket swaggerDoc() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.altimetric.tripMicroservice"))
                .paths(PathSelectors.regex("/api.*"))
                .build()
                .apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(TITLE,DESCRIPTION,SWAGGER_API_VERSION,"Terms of Service",CONTACT,LICENCE_TEXT,"https://www.apache.org/license");
    }
}