package com.order.state;

import com.order.model.OrderContext;

public class Shipped implements OrderState {

    @Override
    public void cancel(OrderContext ctx) {
        System.out.println("Cancel failed: Already shipped");
    }

    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new Delivered());
        System.out.println("→ Delivered");
    }

    @Override
    public void printStatus() {
        System.out.println("Order status: Shipped");
    }
}
