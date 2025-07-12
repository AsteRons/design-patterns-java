package com.order.strategy;

import com.order.model.Order;

public interface PaymentStrategy {

    void pay(Order order, double amount);
}
