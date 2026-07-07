package com.cib.scheduledpayment.service;

import com.cib.scheduledpayment.dto.ScheduledPaymentRequest;
import com.cib.scheduledpayment.dto.ScheduledPaymentResponse;
import com.cib.scheduledpayment.entity.ScheduledPayment;
import com.cib.scheduledpayment.repository.ScheduledPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScheduledPaymentService {

    @Autowired
    private ScheduledPaymentRepository repository;

    public ScheduledPaymentResponse create(ScheduledPaymentRequest request) {

        ScheduledPayment payment = new ScheduledPayment();

        payment.setFromAccount(request.getFromAccount());
        payment.setToAccount(request.getToAccount());
        payment.setAmount(request.getAmount());
        payment.setScheduleDate(LocalDate.parse(request.getScheduleDate()));
        payment.setExecutionTime(request.getExecutionTime());
        payment.setFrequency(request.getFrequency());
        payment.setStatus("SCHEDULED");
        payment.setCreatedDate(LocalDateTime.now());

        ScheduledPayment saved = repository.save(payment);

        ScheduledPaymentResponse response = new ScheduledPaymentResponse();

        response.setId(saved.getId());
        response.setFromAccount(saved.getFromAccount());
        response.setToAccount(saved.getToAccount());
        response.setAmount(saved.getAmount());
        response.setScheduleDate(saved.getScheduleDate().toString());
        response.setExecutionTime(saved.getExecutionTime());
        response.setFrequency(saved.getFrequency());
        response.setStatus(saved.getStatus());

        return response;
    }

    public List<ScheduledPayment> getAll() {
        return repository.findAll();
    }

    public ScheduledPayment getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Scheduled Payment Not Found"));
    }

    public String cancel(Long id) {

        ScheduledPayment payment = getById(id);

        payment.setStatus("CANCELLED");

        repository.save(payment);

        return "Scheduled Payment Cancelled Successfully";
    }
}