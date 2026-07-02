package com.cib.scheduledpayment.exception;

public class ScheduledPaymentNotFoundException
        extends RuntimeException {

    public ScheduledPaymentNotFoundException(
            String message) {

        super(message);
    }
}