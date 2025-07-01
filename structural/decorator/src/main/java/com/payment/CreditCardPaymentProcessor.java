package com.payment;

public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.printf("Processing credit card payment of $%.2f%n", amount);
    }
}
