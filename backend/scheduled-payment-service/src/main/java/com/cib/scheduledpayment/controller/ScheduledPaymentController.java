package com.cib.scheduledpayment.controller;

import com.cib.scheduledpayment.dto.ScheduledPaymentRequest;
import com.cib.scheduledpayment.dto.ScheduledPaymentResponse;
import com.cib.scheduledpayment.entity.ScheduledPayment;
import com.cib.scheduledpayment.service.ScheduledPaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduled-payments")
public class ScheduledPaymentController {

    @Autowired
    private ScheduledPaymentService service;

    @PostMapping
    public ScheduledPaymentResponse create(
            @RequestBody ScheduledPaymentRequest request) {

        return service.create(request);
    }

    @GetMapping
    public List<ScheduledPayment> getAll() {

        return service.getAll();
    }

    @GetMapping("/{id}")
    public ScheduledPayment getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String cancel(
            @PathVariable Long id) {

        return service.cancel(id);
    }
}