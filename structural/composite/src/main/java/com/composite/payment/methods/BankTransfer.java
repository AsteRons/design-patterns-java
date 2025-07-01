package com.composite.payment.methods;

import com.composite.payment.Payment;

public class BankTransfer implements Payment {
    private final String iban;

    public BankTransfer(String iban) {
        this.iban = iban;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paying %.2f PLN via bank transfer from your account %s%n", amount, iban);
    }
}
