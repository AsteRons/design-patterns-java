package com.order.state;

import com.order.model.OrderContext;

public class NewOrder implements OrderState {
    @Override
    public void next(OrderContext ctx) {
        ctx.setState(new Paid());
        System.out.println("→ Paid");
    }

    @Override
    public void cancel(OrderContext ctx) {
        ctx.setState(new Cancelled());
        System.out.println("→ Cancelled");
    }

    @Override
    public void printStatus() {
        System.out.println("Order status: New");
    }
}
