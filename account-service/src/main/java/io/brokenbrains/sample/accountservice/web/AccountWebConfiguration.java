package io.brokenbrains.sample.accountservice.web;


import io.brokenbrains.sample.accountservice.backend.AccountBackendConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
@Import({AccountBackendConfiguration.class, OAS3Config.class})
@ComponentScan
public class AccountWebConfiguration {
}
