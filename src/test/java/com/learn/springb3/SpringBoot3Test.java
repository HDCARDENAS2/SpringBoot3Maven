package com.learn.springb3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(value = "/application.properties")
public class SpringBoot3Test {
    
    @Test
	void contextLoads() {

	}
}
