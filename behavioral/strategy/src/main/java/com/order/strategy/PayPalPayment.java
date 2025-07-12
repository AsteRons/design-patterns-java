package com.order.strategy;

import com.order.model.Order;

public class PayPalPayment implements PaymentStrategy {
    private final String email;
    public PayPalPayment(String email) {
        this.email = email;
    }
    @Override
    public void pay(Order order, double amount) {
        order.setPaid(true);
        System.out.println("Paid " + amount + " using PayPal: " + email);
    }
}
