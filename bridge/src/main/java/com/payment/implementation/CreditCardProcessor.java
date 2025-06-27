package com.payment.implementation;

import java.util.concurrent.CompletableFuture;

public class CreditCardProcessor implements PaymentProcessor {
    @Override
    public CompletableFuture<Boolean> payAsync(double amount, String currency) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("The payment is being processed via credit card: " + amount + " " + currency);

            return false;
        });
    }

    @Override
    public void rollback() {
        System.out.println("Credit card transaction rollback ");
    }
}