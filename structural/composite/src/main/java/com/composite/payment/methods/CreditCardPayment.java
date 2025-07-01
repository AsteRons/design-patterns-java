package com.composite.payment.methods;

import com.composite.payment.Payment;

public class CreditCardPayment implements Payment {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("Paying %.2f PLN with %s credit card. %n", amount, maskCardNumber());
    }

    private String maskCardNumber() {
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }
}