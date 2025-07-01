package com.payment.facade.subsystems;

import com.payment.facade.model.PaymentDetails;
public class PaymentService {
    public void transfer(PaymentDetails details) {
        System.out.printf("Transferring %.2f from %s to %s%n",
                details.getAmount(), details.getAccountFrom(), details.getAccountTo());
    }
}
