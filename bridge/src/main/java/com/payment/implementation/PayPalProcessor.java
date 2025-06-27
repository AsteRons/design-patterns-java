package com.payment.implementation;

import java.util.concurrent.CompletableFuture;

public class PayPalProcessor implements PaymentProcessor {
    @Override
    public CompletableFuture<Boolean> payAsync(double amount, String currency) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("The payment is being processed through PayPal: " + amount + " " + currency);

            return true;
        });
    }

    @Override
    public void rollback() {
        System.out.println("Rollback PayPal");
    }
}
