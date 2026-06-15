package com.cib.fraud.controller;

import com.cib.fraud.dto.FraudRequest;
import com.cib.fraud.dto.FraudResponse;
import com.cib.fraud.service.FraudDetectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fraud")
public class FraudController {

    private final FraudDetectionService service;

    public FraudController(
            FraudDetectionService service) {

        this.service = service;
    }

    @PostMapping("/check")
    public FraudResponse check(
            @RequestBody FraudRequest request) {

        return service.analyze(request);
    }
}