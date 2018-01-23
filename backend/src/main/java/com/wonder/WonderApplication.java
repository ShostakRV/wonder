package com.wonder;

import com.wonder.config.jms.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class WonderApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(WonderApplication.class, args);

        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("b.missurenko@ukr.net", "Hello"));
    }
}
