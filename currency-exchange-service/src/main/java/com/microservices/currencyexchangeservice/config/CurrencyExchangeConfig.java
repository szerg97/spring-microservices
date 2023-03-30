package com.microservices.currencyexchangeservice.config;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CurrencyExchangeConfig {

    private final EurekaClientConfigBean bean;

    @Value("${eureka.client.service-url.default-zone}")
    private String serviceUrl;
    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeConfig.class);

    @PostConstruct
    public void init(){
        logger.info("SERVICE URL from app json: {}", serviceUrl);
        logger.info("SERVICE URL from bean: {}", bean.getServiceUrl());
    }
}
