package com.learn.springb3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public OpenAPI myOpenAPI() {
      Info info = new Info()
          .title("API SpringBoot 3")
          .version("0.0.1")
          .description("SpringBoot 3");

      return new OpenAPI().info(info);
    }

   public InternalResourceViewResolver defaultViewResolver() {
     return new InternalResourceViewResolver();
   }
}
