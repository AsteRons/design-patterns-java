package com.order.model;


import com.order.strategy.PaymentStrategy;


public class Order {
    private boolean paid;

    private PaymentStrategy paymentStrategy;


    public Order(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }

    public void process(double amount) {
        paymentStrategy.pay(this, amount);
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    public boolean isPaid() {
        return paid;
    }
}
