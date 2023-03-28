package com.microservices.limitservice.controller;

import com.microservices.limitservice.config.LimitConfiguration;
import com.microservices.limitservice.model.Limits;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("limits")
@RequiredArgsConstructor
public class LimitController {

    private final LimitConfiguration limitConfiguration;

    @GetMapping("")
    public Limits getAllLimits(){
        return new Limits(
                limitConfiguration.getMinimum(),
                limitConfiguration.getMaximum());
    }
}
