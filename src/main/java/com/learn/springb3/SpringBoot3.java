package com.learn.springb3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBoot3 {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3.class, args);
    }

}
