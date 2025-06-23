package com.payment.provider.stripe;

import com.payment.domain.PaymentService;

public class StripePaymentService implements PaymentService {

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Stripe: Payment of " + amount + " " + currency + " processed.");
    }
}
