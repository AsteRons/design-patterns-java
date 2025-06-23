package com.payment.provider.stripe;

import com.payment.domain.RefundService;

public class StripeRefundService implements RefundService {
    @Override
    public void refund(String transactionId) {
        System.out.println("Stripe: Refund processed for transaction " + transactionId);
    }
}
