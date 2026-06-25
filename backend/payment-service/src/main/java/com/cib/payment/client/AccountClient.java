package com.cib.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        name = "account-service",
        url = "http://localhost:8082")
public interface AccountClient {

    @GetMapping(
            "/api/accounts/account-number")
    Object getAccount(

            @RequestParam("accountNumber")
            String accountNumber);

    @PutMapping(
            "/api/accounts/debit/{accountNumber}")
    Object debit(

            @PathVariable("accountNumber")
            String accountNumber,

            @RequestParam("amount")
            Double amount);

    @PutMapping(
            "/api/accounts/credit/{accountNumber}")
    Object credit(

            @PathVariable("accountNumber")
            String accountNumber,

            @RequestParam("amount")
            Double amount);
}