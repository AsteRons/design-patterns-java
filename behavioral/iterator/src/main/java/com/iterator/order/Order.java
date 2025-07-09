package com.iterator.order;

public record Order(String orderId, double totalAmount) {

    @Override
    public String toString() {
        return "Order{id='" + orderId + "', amount=" + totalAmount + "}";
    }
}
