package com.order.model;

import com.order.state.NewOrder;
import com.order.state.OrderState;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new NewOrder();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}