package com.order.state;

import com.order.model.OrderContext;

public interface OrderState {
    void next(OrderContext ctx);

    void cancel(OrderContext ctx);

    void printStatus();
}