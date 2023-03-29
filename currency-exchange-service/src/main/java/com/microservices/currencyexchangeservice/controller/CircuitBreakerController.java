package com.microservices.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
    public String sampleApi(){
        logger.info("Sample API call received");
        ResponseEntity<String> forEntity = new RestTemplate()
                .getForEntity(
                        "http://localhost:8080/some-dummy-url",
                        String.class);
        return forEntity.getBody();
    }

    private String hardCodedResponse(RuntimeException e){
        return "fallback-response";
    }
}
