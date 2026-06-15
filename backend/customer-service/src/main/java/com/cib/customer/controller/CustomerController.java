package com.cib.customer.controller;

import com.cib.customer.dto.CustomerRequest;
import com.cib.customer.entity.Customer;
import com.cib.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(
            @RequestBody CustomerRequest request) {

        return customerService.createCustomer(request);
    }

    @GetMapping("/customer-id/{customerId}")
    public Customer getByCustomerId(
            @PathVariable String customerId) {

        return customerService.getByCustomerId(customerId);
    }

    @PutMapping("/{customerId}/kyc")
    public Customer verifyKyc(
            @PathVariable String customerId) {

        return customerService.verifyKyc(customerId);
    }

    @PutMapping("/{customerId}/block")
    public Customer blockCustomer(
            @PathVariable String customerId) {

        return customerService.blockCustomer(customerId);
    }

    @PutMapping("/{customerId}/activate")
    public Customer activateCustomer(
            @PathVariable String customerId) {

        return customerService.activateCustomer(customerId);
    }
}