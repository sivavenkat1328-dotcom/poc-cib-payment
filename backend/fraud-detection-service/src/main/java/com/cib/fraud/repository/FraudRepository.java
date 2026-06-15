package com.cib.fraud.repository;

import com.cib.fraud.entity.FraudTransaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FraudRepository {

    private final List<FraudTransaction> transactions =
            new ArrayList<>();

    public FraudTransaction save(
            FraudTransaction transaction) {

        transactions.add(transaction);
        return transaction;
    }

    public List<FraudTransaction> findAll() {

        return transactions;
    }

    public Optional<FraudTransaction> findById(
            Long id) {

        return transactions.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    public void deleteById(Long id) {

        transactions.removeIf(
                t -> t.getId().equals(id));
    }

    public long count() {

        return transactions.size();
    }
}