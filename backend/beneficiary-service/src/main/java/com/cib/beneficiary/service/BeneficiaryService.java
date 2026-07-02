package com.cib.beneficiary.service;

import com.cib.beneficiary.dto.BeneficiaryRequest;
import com.cib.beneficiary.dto.BeneficiaryResponse;
import com.cib.beneficiary.entity.Beneficiary;
import com.cib.beneficiary.exception.BeneficiaryNotFoundException;
import com.cib.beneficiary.repository.BeneficiaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiaryService {

    @Autowired
    private BeneficiaryRepository repository;

    public BeneficiaryResponse addBeneficiary(
            BeneficiaryRequest request) {

        Beneficiary beneficiary =
                new Beneficiary();

        beneficiary.setBeneficiaryId(
                "BEN-" + System.currentTimeMillis());

        beneficiary.setCustomerId(
                request.getCustomerId());

        beneficiary.setBeneficiaryName(
                request.getBeneficiaryName());

        beneficiary.setBeneficiaryAccount(
                request.getBeneficiaryAccount());

        beneficiary.setBankName(
                request.getBankName());

        beneficiary.setIfscCode(
                request.getIfscCode());

        beneficiary.setStatus("ACTIVE");

        repository.save(beneficiary);

        BeneficiaryResponse response =
                new BeneficiaryResponse();

        response.setBeneficiaryId(
                beneficiary.getBeneficiaryId());

        response.setStatus(
                beneficiary.getStatus());

        return response;
    }

    public List<Beneficiary> getBeneficiaries(
            String customerId) {

        return repository.findByCustomerId(
                customerId);
    }

    public String deleteBeneficiary(
            Long id) {

        Beneficiary beneficiary =
                repository.findById(id)
                        .orElseThrow(() ->
                                new BeneficiaryNotFoundException(
                                        "Beneficiary Not Found"));

        repository.delete(beneficiary);

        return "Beneficiary Deleted Successfully";
    }
}