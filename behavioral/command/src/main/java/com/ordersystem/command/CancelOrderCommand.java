package com.ordersystem.command;

import com.ordersystem.reciver.Order;

public class CancelOrderCommand implements Command {
    private final Order order;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.cancel();
    }

    @Override
    public void undo() {
        order.place();
    }
}
