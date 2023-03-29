package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    private final CurrencyExchangeService service;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getOne(
            @PathVariable String from,
            @PathVariable String to
    ){
        logger.info("Get exchange was called: from {} to {}", from, to);
        return service.getOne(from, to);
    }
}
