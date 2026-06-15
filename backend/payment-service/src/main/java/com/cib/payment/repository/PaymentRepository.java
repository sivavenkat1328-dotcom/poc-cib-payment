package com.cib.payment.repository;

import com.cib.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository
        extends JpaRepository<Payment, Long> {
}