package com.payment.implementation;

import java.util.concurrent.CompletableFuture;

public interface PaymentProcessor {
    CompletableFuture<Boolean> payAsync(double amount, String currency);
    void rollback();
}
