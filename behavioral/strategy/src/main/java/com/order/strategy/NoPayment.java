package com.order.strategy;

import com.order.model.Order;

public class NoPayment implements PaymentStrategy {

    @Override
    public void pay(Order order, double amount) {

        System.out.println("No payment processed.");
    }
}
