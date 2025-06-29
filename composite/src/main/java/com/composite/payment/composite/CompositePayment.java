package com.composite.payment.composite;

import com.composite.payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class CompositePayment implements Payment {
    private List<Payment> methods;

    public CompositePayment() {
        methods = new ArrayList<>();
    }

    public void add(Payment payment) {
        methods.add(payment);
    }

    public void remove(Payment payment) {
        methods.remove(payment);
    }

    @Override
    public void pay(double amount) {
        if (methods.isEmpty()) {
            System.out.println("No payment methods available!");
            return;
        }

        double splitAmount = amount / methods.size();
        for (Payment method : methods) {
            method.pay(splitAmount);
        }
    }
}
