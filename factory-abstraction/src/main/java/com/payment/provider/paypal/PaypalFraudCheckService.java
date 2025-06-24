package com.payment.provider.paypal;


import com.payment.domain.FraudCheckService;

class PaypalFraudCheckService implements FraudCheckService {
    @Override
    public boolean checkFraud(String userId, double amount) {
        System.out.println("PayPal: Advanced fraud detection for user " + userId);
        return amount < 3000;
    }
}
