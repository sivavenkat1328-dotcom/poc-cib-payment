package com.cib.payment.controller;

import com.cib.payment.dto.PaymentRequest;
import com.cib.payment.dto.PaymentResponse;
import com.cib.payment.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public PaymentResponse create(
            @RequestBody PaymentRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public String getPayment(
            @PathVariable Long id) {
        return "Payment : " + id;
    }

    @GetMapping
    public String getAllPayments() {
        return "All Payments";
    }

    @PutMapping("/{id}")
    public String updatePayment(
            @PathVariable Long id,
            @RequestBody PaymentRequest request) {
        return "Payment Updated : " + id;
    }

    @DeleteMapping("/{id}")
    public String deletePayment(
            @PathVariable Long id) {
        return "Payment Deleted : " + id;
    }

    @GetMapping("/{id}/status")
    public String paymentStatus(
            @PathVariable Long id) {
        return service.paymentStatus(id);
    }

    @PostMapping("/{id}/cancel")
    public String cancelPayment(
            @PathVariable Long id) {
        return service.cancelPayment(id);
    }

    @PostMapping("/{id}/refund")
    public String refundPayment(
            @PathVariable Long id) {
        return service.refundPayment(id);
    }
}