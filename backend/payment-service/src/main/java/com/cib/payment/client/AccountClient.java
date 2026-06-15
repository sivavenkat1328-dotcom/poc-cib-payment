package com.cib.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "account-service")
public interface AccountClient {

    @GetMapping(
            "/api/accounts/account-number/{accountNumber}")
    Object getAccount(
            @PathVariable("accountNumber")
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