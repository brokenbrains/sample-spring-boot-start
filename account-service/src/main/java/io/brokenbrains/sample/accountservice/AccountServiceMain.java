package io.brokenbrains.sample.accountservice;

import io.brokenbrains.sample.accountservice.web.AccountWebConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({AccountWebConfiguration.class,
})
public class AccountServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceMain.class, args);
    }
}
