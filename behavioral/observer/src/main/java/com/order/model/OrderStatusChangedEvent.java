package com.order.model;

import com.order.model.Order;

public class OrderStatusChangedEvent {
    private final Order order;
    private final String oldStatus;
    private final String newStatus;

    public OrderStatusChangedEvent(Order order, String oldStatus, String newStatus) {
        this.order = order;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
    }

    public Order getOrder() {
        return order;
    }

    public String getOldStatus() {
        return oldStatus;
    }

    public String getNewStatus() {
        return newStatus;
    }
}
