package com.order.strategy;

import com.order.model.Order;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Override
    public void pay(Order order, double amount) {

        order.setPaid(true);
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}
