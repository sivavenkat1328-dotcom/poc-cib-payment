package com.cib.fraud.controller;

import com.cib.fraud.dto.FraudRequest;
import com.cib.fraud.dto.FraudResponse;
import com.cib.fraud.entity.FraudDetection;
import com.cib.fraud.service.FraudDetectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud")
public class FraudController {

    private final FraudDetectionService service;

    public FraudController(FraudDetectionService service) {
        this.service = service;
    }

    // Check Fraud
    @PostMapping("/check")
    public FraudResponse check(@RequestBody FraudRequest request) {
        return service.analyze(request);
    }



    // Delete Fraud Record
    @DeleteMapping("/{id}")
    public String deleteFraud(@PathVariable Long id) {
        return service.deleteFraud(id);
    }

    // Health Check
    @GetMapping("/health")
    public String health() {
        return "Fraud Detection Service is Running";
    }
}