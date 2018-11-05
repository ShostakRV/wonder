package com.wonder;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class WonderApplication {
    public static void main(String[] args) {
        SpringApplication.run(WonderApplication.class, args);

    }
}
