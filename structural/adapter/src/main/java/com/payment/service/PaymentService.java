package com.payment.service;

import com.payment.domain.PaymentRequest;
import com.payment.domain.PaymentResponse;
import com.payment.port.PaymentProcessor;

public class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void makePayment(String customerId, double amount) {
        PaymentRequest request = new PaymentRequest(customerId, amount);
        PaymentResponse response = paymentProcessor.processPayment(request);

        if (response.success()) {
            System.out.println("Payment successful! Transaction ID: " + response.transactionId());
        } else {
            System.out.println("Payment failed.");
        }
    }
}