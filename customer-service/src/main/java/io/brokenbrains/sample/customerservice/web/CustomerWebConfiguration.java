package io.brokenbrains.sample.customerservice.web;


import io.brokenbrains.sample.customerservice.backend.CustomerBackendConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CustomerBackendConfiguration.class, OAS3Config.class})
@ComponentScan
public class CustomerWebConfiguration {
}
