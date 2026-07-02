package com.cib.account.service;

import com.cib.account.client.CustomerClient;
import com.cib.account.dto.AccountRequest;
import com.cib.account.entity.Account;
import com.cib.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Autowired
    private CustomerClient customerClient;

    public Account createAccount(AccountRequest request) {

        try {
            customerClient.getCustomer(
                    request.getCustomerId());
        }
        catch (Exception ex) {
            throw new RuntimeException(
                    "Customer does not exist");
        }

        Account account = new Account();

        account.setAccountNumber(
                "ACC-" + System.currentTimeMillis());

        account.setCustomerId(
                request.getCustomerId());

        account.setAccountType(
                request.getAccountType());

        account.setBalance(
                request.getOpeningBalance());

        account.setAccountStatus(
                "ACTIVE");

        account.setCurrency(
                "INR");

        account.setBranchCode(
                "BLR001");

        return repository.save(account);
    }

    public Account getByAccountNumber(
            String accountNumber) {

        return repository
                .findByAccountNumber(accountNumber)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Account Not Found"));
    }

    public List<Account> getAllAccounts() {

        return repository.findAll();
    }

    public Account debit(
            String accountNumber,
            Double amount) {

        Account account =
                getByAccountNumber(accountNumber);

        if (account.getBalance() < amount) {

            throw new RuntimeException(
                    "Insufficient Balance");
        }

        account.setBalance(
                account.getBalance() - amount);

        return repository.save(account);
    }

    public Account credit(
            String accountNumber,
            Double amount) {

        Account account =
                getByAccountNumber(accountNumber);

        account.setBalance(
                account.getBalance() + amount);

        return repository.save(account);
    }

    public void deleteByAccountNumber(
            String accountNumber) {

        Account account =
                repository
                        .findByAccountNumber(accountNumber)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Account Not Found"));

        repository.delete(account);
    }

    public String freezeAccount(Long id) {

        Account account = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Account Not Found"));

        account.setAccountStatus("FROZEN");

        repository.save(account);

        return "Account Frozen Successfully";
    }

    public String unfreezeAccount(Long id) {

        Account account = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Account Not Found"));

        account.setAccountStatus("ACTIVE");

        repository.save(account);

        return "Account Unfrozen Successfully";
    }
}