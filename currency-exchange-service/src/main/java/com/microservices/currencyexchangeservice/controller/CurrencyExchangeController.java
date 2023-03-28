package com.microservices.currencyexchangeservice.controller;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.microservices.currencyexchangeservice.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final CurrencyExchangeService service;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getOne(
            @PathVariable String from,
            @PathVariable String to
    ){
        return service.getOne(from, to);
    }
}
