package com.microservices.currencyexchangeservice.service;

import com.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrencyExchangeService {

    private final List<CurrencyExchange> list = new ArrayList<>();

    public List<CurrencyExchange> getAll(){
        return list;
    }

    public CurrencyExchange getOne(String from, String to){
        return list.stream()
                .filter(c -> c.getFrom().equals(from) && c.getTo().equals(to))
                .findFirst().orElseThrow();
    }
}
