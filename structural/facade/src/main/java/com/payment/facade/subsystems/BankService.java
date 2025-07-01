package com.payment.facade.subsystems;

import com.payment.facade.model.PaymentDetails;
public class BankService {
    public boolean hasSufficientFunds(PaymentDetails details) {
        System.out.println("Checking balance for account: " + details.getAccountFrom());
        return details.getAmount() <= 1000.0;
    }
}
