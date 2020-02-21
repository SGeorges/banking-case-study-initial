package com.example.banking;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrchestratorConfig {

    @Bean
    public RestTemplate getTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate;
    }
}
