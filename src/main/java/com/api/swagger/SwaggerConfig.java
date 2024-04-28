package com.api.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.api.webservice.rest"))
            .paths(PathSelectors.regex("/.*"))
            .build();
        }
    
    public ApiInfo custInfo()
    {
       ApiInfo apiInfo = new ApiInfo(
               "Employee Managememnt",  // Title
               "Employee Service",      // Description 
               "1.0",                   // Version
               "TOS",                   // Terms of Service
               new Contact("JavaInterviewPoint", "//javainterviewpoint.com/spring-mvc-tutorial/", "test@test.com"), // Contact
               "JIPlicense",            // License
               "//javainterviewpoint.com/"); //License URL
       
        return apiInfo;
    }
}