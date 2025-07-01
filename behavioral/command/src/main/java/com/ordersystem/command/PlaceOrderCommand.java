package com.ordersystem.command;

import com.ordersystem.reciver.Order;

public class PlaceOrderCommand implements Command {

    private final Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        order.place();

    }

    @Override
    public void undo() {
    order.cancel();
    }
}
