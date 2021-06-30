package com.guide.cm.feecalculation.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${max.fee}")
    private String maxLimit;

    @GetMapping("sayHello")
    public String sayHello()
    {
       return maxLimit;
    }
}
