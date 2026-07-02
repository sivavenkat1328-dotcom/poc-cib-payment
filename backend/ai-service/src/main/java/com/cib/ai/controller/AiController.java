package com.cib.ai.controller;

import com.cib.ai.dto.AiRequest;
import com.cib.ai.dto.AiResponse;
import com.cib.ai.service.AiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiController {

    @Autowired
    private AiService service;

    @PostMapping("/ask")
    public AiResponse askQuestion(
            @RequestBody AiRequest request) {

        return service.askQuestion(
                request);
    }

    @PostMapping("/fraud-check")
    public AiResponse fraudCheck(
            @RequestBody AiRequest request) {

        return service.fraudCheck(
                request);
    }

    @GetMapping("/recommendation/{customerId}")
    public AiResponse recommendation(
            @PathVariable String customerId) {

        return service.recommendation(
                customerId);
    }
}