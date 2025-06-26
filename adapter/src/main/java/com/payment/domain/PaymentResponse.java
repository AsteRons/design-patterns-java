package com.payment.domain;

public record PaymentResponse(boolean success, String transactionId) {
}