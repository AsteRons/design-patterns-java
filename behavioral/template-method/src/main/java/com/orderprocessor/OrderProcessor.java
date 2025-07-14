package com.orderprocessor;

public abstract class OrderProcessor {


    public final void processOrder() {
        validateOrder();
        chargeCustomer();
        shipOrder();
        sendConfirmation();
    }

    protected abstract void validateOrder();
    protected abstract void chargeCustomer();
    protected abstract void shipOrder();

    protected void sendConfirmation() {
        System.out.println("Sending order confirmation email...");
    }
}