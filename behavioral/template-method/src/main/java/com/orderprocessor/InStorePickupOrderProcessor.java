package com.orderprocessor;

public class InStorePickupOrderProcessor extends OrderProcessor {

    @Override
    protected void validateOrder() {
        System.out.println("Validating in-store pickup availability...");
    }

    @Override
    protected void chargeCustomer() {
        System.out.println("Reserving payment for in-store pickup...");
    }

    @Override
    protected void shipOrder() {
        System.out.println("Notifying store staff for pickup preparation...");
    }

    @Override
    protected void sendConfirmation() {
        System.out.println("Sending pickup confirmation SMS...");
    }
}
