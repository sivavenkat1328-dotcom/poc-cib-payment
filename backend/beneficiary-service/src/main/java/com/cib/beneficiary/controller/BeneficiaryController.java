package com.cib.beneficiary.controller;

import com.cib.beneficiary.dto.BeneficiaryRequest;
import com.cib.beneficiary.dto.BeneficiaryResponse;
import com.cib.beneficiary.entity.Beneficiary;
import com.cib.beneficiary.service.BeneficiaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService service;

    @PostMapping
    public BeneficiaryResponse addBeneficiary(
            @RequestBody BeneficiaryRequest request) {

        return service.addBeneficiary(
                request);
    }

    @GetMapping("/customer/{customerId}")
    public List<Beneficiary> getBeneficiaries(
            @PathVariable String customerId) {

        return service.getBeneficiaries(
                customerId);
    }

    @DeleteMapping("/{id}")
    public String deleteBeneficiary(
            @PathVariable Long id) {

        return service.deleteBeneficiary(
                id);
    }
}