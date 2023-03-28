package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.model.CurrencyConversion;
import com.microservices.currencyconversionservice.model.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/currency-conversion")
@RequiredArgsConstructor
public class CurrencyConversionController {


    @GetMapping("/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion getOne(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable int quantity
    ){
        CurrencyExchange exchange = new RestTemplate().getForEntity(
                "http://localhost:8000/currency-exchange" +
                        "/from/" + from + "/to/" + to, CurrencyExchange.class)
                .getBody();
        return new CurrencyConversion(
                exchange.getFrom(),
                exchange.getTo(),
                quantity,
                exchange.getConversionMultiple() * quantity);
    }
}
