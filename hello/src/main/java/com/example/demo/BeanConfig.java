package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Autowired
    private TestClient testClient;

    @Bean
    public TestBean testBean() {
        System.out.println("start testBean");
        final String test = testClient.test();
        System.out.println("test = " + test);
        return new TestBean();
    }


}
