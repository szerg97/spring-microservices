package com.microservices.limitservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limit-service")
@Data
public class LimitConfiguration {
    private int minimum;
    private int maximum;
}
