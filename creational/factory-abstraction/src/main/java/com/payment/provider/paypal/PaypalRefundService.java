package com.payment.provider.paypal;

import com.payment.domain.RefundService;

class PaypalRefundService implements RefundService {
    @Override
    public void refund(String transactionId) {
        System.out.println("PayPal: Refund processed for transaction " + transactionId);
    }
}
