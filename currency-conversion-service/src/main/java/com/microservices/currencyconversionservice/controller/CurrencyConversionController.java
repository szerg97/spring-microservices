package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.model.CurrencyConversion;
import com.microservices.currencyconversionservice.model.CurrencyExchange;
import com.microservices.currencyconversionservice.proxy.CurrencyExchangeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {

    private final CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/{quantity}")
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

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/{quantity}")
    public CurrencyConversion getOneWithFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable int quantity
    ){
        CurrencyExchange exchange = proxy.getExchange(from, to);
        return new CurrencyConversion(
                exchange.getFrom(),
                exchange.getTo(),
                quantity,
                exchange.getConversionMultiple() * quantity);
    }
}
