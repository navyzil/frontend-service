package com.stakater.techincal.task.frontendservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class FrontendServiceConfig {
    @Value("${frontend.backend.api.rest.url}")
    private String backendRestApiUrl;

    public String getBackendRestApiUrl() {
        return backendRestApiUrl;
    }

    public void setBackendRestApiUrl(String backendRestApiUrl) {
        this.backendRestApiUrl = backendRestApiUrl;
    }

    @Bean
    public RestTemplate rest(){
        return new RestTemplate();
    }
}
