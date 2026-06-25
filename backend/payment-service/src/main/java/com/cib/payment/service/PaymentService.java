package com.cib.payment.service;

import com.cib.payment.client.AccountClient;
import com.cib.payment.client.TransactionClient;
import com.cib.payment.dto.PaymentRequest;
import com.cib.payment.dto.PaymentResponse;
import com.cib.payment.dto.TransactionRequest;
import com.cib.payment.entity.Payment;
import com.cib.payment.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private TransactionClient transactionClient;

    public PaymentResponse create(
            PaymentRequest request) {

        if (request.getAmount() <= 0) {

            throw new RuntimeException(
                    "Invalid Amount");
        }

        // Validate Accounts

        accountClient.getAccount(
                request.getFromAccount());

        accountClient.getAccount(
                request.getToAccount());

        // Debit Source Account

        accountClient.debit(
                request.getFromAccount(),
                request.getAmount());

        // Credit Destination Account

        accountClient.credit(
                request.getToAccount(),
                request.getAmount());

        // Create Transaction

        TransactionRequest txn =
                new TransactionRequest();

        txn.setFromAccount(
                request.getFromAccount());

        txn.setToAccount(
                request.getToAccount());

        txn.setAmount(
                request.getAmount());

        txn.setTransactionType(
                "TRANSFER");

        transactionClient.createTransaction(
                txn);

        // Generate IDs

        String paymentId =
                "PAY-" +
                        System.currentTimeMillis();

        String txnId =
                "TXN-" +
                        System.currentTimeMillis();

        // Save Payment

        Payment payment =
                new Payment();

        payment.setPaymentId(
                paymentId);

        payment.setTransactionId(
                txnId);

        payment.setFromAccount(
                request.getFromAccount());

        payment.setToAccount(
                request.getToAccount());

        payment.setAmount(
                request.getAmount());

        payment.setStatus(
                "SUCCESS");

        paymentRepository.save(
                payment);

        // Response

        PaymentResponse response =
                new PaymentResponse();

        response.setPaymentId(
                paymentId);

        response.setTransactionId(
                txnId);

        response.setStatus(
                "SUCCESS");

        response.setMessage(
                "Fund Transfer Successful");

        return response;
    }

    public String paymentStatus(
            Long id) {

        return "SUCCESS";
    }

    public String cancelPayment(
            Long id) {

        return "Payment Cancelled";
    }

    public String refundPayment(
            Long id) {

        return "Payment Refunded";
    }
}