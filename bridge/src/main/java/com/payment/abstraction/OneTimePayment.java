package com.payment.abstraction;

import com.payment.implementation.PaymentProcessor;

import java.util.List;

public class OneTimePayment extends Payment {
    public OneTimePayment(List<PaymentProcessor> processors) {
        super(processors);
    }
}
