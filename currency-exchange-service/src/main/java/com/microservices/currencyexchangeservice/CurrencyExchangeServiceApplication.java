package com.microservices.currencyexchangeservice;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class CurrencyExchangeServiceApplication {

    private final CurrencyExchangeService service;

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
    }

    @PostConstruct
    public void seed(){
        service.getAll().addAll(List.of(
           new CurrencyExchange(
                   1001L,
                   "EUR",
                   "HUF",
                   350.7,
                   "N/A"
           ),
            new CurrencyExchange(
                    1002L,
                    "HUF",
                    "EUR",
                    0.003,
                    "N/A"
            )
        ));
    }
}
