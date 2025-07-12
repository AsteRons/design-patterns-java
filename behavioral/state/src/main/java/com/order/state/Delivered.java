package com.order.state;

import com.order.model.OrderContext;

public class Delivered implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Already delivered!");
    }

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Cancel failed: Already delivered");
    }

    @Override
    public void printStatus() {
        System.out.println("Order status: Delivered");
    }
}
