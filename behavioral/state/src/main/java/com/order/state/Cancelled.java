package com.order.state;

import com.order.model.OrderContext;

public class Cancelled implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        System.out.println("Canceled order can’t proceed");
    }

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Already cancelled");
    }

    @Override
    public void printStatus() {
        System.out.println("Order status: Cancelled");
    }
}
