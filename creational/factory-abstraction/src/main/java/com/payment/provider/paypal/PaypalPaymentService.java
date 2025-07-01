package com.payment.provider.paypal;

import com.payment.domain.PaymentService;

class PaypalPaymentService implements PaymentService {
    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("PayPal: Payment of " + amount + " " + currency + " processed.");
    }
}
