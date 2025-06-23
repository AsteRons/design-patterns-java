package com.payment.provider.stripe;

import com.payment.domain.FraudCheckService;

public class StripeFraudCheckService implements FraudCheckService {
    @Override
    public boolean checkFraud(String userId, double amount) {

        System.out.println("Stripe: Running fraud check for user " + userId);
        return amount < 5000;
    }
}
