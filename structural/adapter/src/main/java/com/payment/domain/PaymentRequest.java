package com.payment.domain;

public record PaymentRequest(String customerId, double amount) {
}