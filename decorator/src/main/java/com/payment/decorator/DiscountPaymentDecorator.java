package com.payment.decorator;

import com.payment.PaymentProcessor;

public class DiscountPaymentDecorator extends PaymentProcessorDecorator {
    private final double discountRate;

    public DiscountPaymentDecorator(PaymentProcessor processor, double discountRate) {
        super(processor);
        this.discountRate = discountRate;
    }

    @Override
    public void pay(double amount) {
        double discountedAmount = amount * (1 - discountRate);
        System.out.printf("Applying discount: original $%.2f, discounted $%.2f%n", amount, discountedAmount);
        super.pay(discountedAmount);
    }
}
