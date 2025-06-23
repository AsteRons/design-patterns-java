package com.payment.domain;

public interface PaymentService {
    void processPayment(double amount, String currency);
}
