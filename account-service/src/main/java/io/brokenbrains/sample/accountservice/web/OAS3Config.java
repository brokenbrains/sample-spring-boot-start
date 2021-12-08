package io.brokenbrains.sample.accountservice.web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OAS3Config {

    @Value("${config.server.url}")
    private String serverUrl;

    @Bean
    public OpenAPI serviceOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url(serverUrl));
    }
}
