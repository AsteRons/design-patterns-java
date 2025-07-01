package com.ordersystem.reciver;

public class Order {

    private final String orderId;

    public Order(String orderId) {
        this.orderId = orderId;
    }

    public void place() {
        System.out.println("Order " + orderId + " has been placed.");
    }

    public void cancel() {
        System.out.println("Order " + orderId + " has been canceled.");
    }

}
