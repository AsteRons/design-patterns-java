package com.orderprocessor;

public class OnlineOrderProcessor extends OrderProcessor {

    @Override
    protected void validateOrder() {
        System.out.println("Validating online order with inventory and payment method...");
    }

    @Override
    protected void chargeCustomer() {
        System.out.println("Charging customer via online payment gateway...");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Shipping order to customer's delivery address...");
    }
}
