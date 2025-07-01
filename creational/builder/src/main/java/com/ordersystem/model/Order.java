package com.ordersystem.model;

import java.util.Collections;
import java.util.List;


public final class Order {

    private final String orderId;
    private final Address shippingAddress;
    private final List<Item> items;
    private final boolean expedited;

    public Order(OrderBuilder<?> builder) {
        this.orderId = builder.getOrderId();
        this.shippingAddress = builder.getShippingAddress();
        this.items = Collections.unmodifiableList(builder.getItems());
        this.expedited = builder.isExpedited();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", shippingAddress=" + shippingAddress +
                ", items=" + items +
                ", expedited=" + expedited +
                '}';
    }
}