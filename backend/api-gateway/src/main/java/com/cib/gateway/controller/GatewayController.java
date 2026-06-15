package com.cib.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/")
    public String home() {
        return "CIB API Gateway Running Successfully";
    }

    @GetMapping("/health")
    public String health() {
        return "Gateway Health OK";
    }
}