package com.cib.scheduledpayment.repository;

import com.cib.scheduledpayment.entity.ScheduledPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduledPaymentRepository
        extends JpaRepository<ScheduledPayment, Long> {
}