package com.cib.account.controller;

import com.cib.account.dto.AccountRequest;
import com.cib.account.entity.Account;
import com.cib.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    public Account createAccount(
            @RequestBody AccountRequest request) {

        return service.createAccount(request);
    }

    @GetMapping("/account-number/{accountNumber}")
    public Account getAccount(
            @PathVariable String accountNumber) {

        return service.getByAccountNumber(accountNumber);
    }

    // View All Accounts API
    @GetMapping
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @PutMapping("/debit/{accountNumber}")
    public Account debit(
            @PathVariable String accountNumber,
            @RequestParam Double amount) {

        return service.debit(accountNumber, amount);
    }

    @PutMapping("/credit/{accountNumber}")
    public Account credit(
            @PathVariable String accountNumber,
            @RequestParam Double amount) {

        return service.credit(accountNumber, amount);
    }
}