package com.learn.springb3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig {

   @Bean
   Docket api() {           
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(apiInfo())
                .select()                                
  	            .apis(RequestHandlerSelectors.basePackage("com.learn.springb3.controller"))              
  	            .paths(PathSelectors.any())          
                .build();
    }
   
   private ApiInfo apiInfo() {
	    return new ApiInfoBuilder().title("API SpringBoot 3").version("0.0.1")
	            .description("SpringBoot 3")
	            .build();
   }

   public InternalResourceViewResolver defaultViewResolver() {
     return new InternalResourceViewResolver();
   }
}
