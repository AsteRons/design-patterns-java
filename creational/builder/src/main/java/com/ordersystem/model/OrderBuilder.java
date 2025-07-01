package com.ordersystem.model;

import java.util.ArrayList;
import java.util.List;

public class OrderBuilder<T extends OrderBuilder<T>> {

    private String orderId;
    private Address shippingAddress;
    private final List<Item> items = new ArrayList<>();
    private boolean expedited;

    public T orderId(String orderId) {
        this.orderId = orderId;
        return self();
    }

    public T shippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
        return self();
    }

    public T addItem(Item item) {
        this.items.add(item);
        return self();
    }

    public T expedited(boolean expedited) {
        this.expedited = expedited;
        return self();
    }

    public Order build() {
        validate();
        return new Order(this);
    }

    protected void validate() {
        if (orderId == null || orderId.isBlank()) {
            throw new IllegalStateException("OrderId is required");
        }
        if (shippingAddress == null) {
            throw new IllegalStateException("Shipping address is required");
        }
        if (items.isEmpty()) {
            throw new IllegalStateException("At least one item is required");
        }
    }

    @SuppressWarnings("unchecked")
    protected T self() {
        return (T) this;
    }
    public String getOrderId() {
        return orderId;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isExpedited() {
        return expedited;
    }
}
