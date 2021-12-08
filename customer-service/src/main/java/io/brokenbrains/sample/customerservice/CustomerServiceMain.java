package io.brokenbrains.sample.customerservice;

import io.brokenbrains.sample.customerservice.web.CustomerWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomerWebConfiguration.class})
@EnableAutoConfiguration
public class CustomerServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceMain.class, args);
    }
}
