package com.payment.facade;

import com.payment.facade.model.PaymentDetails;
import com.payment.facade.model.User;
import com.payment.facade.subsystems.AuthService;
import com.payment.facade.subsystems.BankService;
import com.payment.facade.subsystems.LoggerService;
import com.payment.facade.subsystems.PaymentService;

public class PaymentFacade {

    private AuthService authService = new AuthService();
    private BankService bankService = new BankService();
    private PaymentService paymentService = new PaymentService();
    private LoggerService loggerService = new LoggerService();

    public PaymentFacade(AuthService authService,
                         BankService bankService,
                         PaymentService paymentService,
                         LoggerService loggerService) {

        this.authService = authService;
        this.bankService = bankService;
        this.paymentService = paymentService;
        this.loggerService = loggerService;
    }

    public void makePayment(User user, PaymentDetails details) {
        loggerService.log("Payment started");

        if (!authService.authenticate(user)) {
            loggerService.log("Authentication failed");
            throw new SecurityException("User not authenticated");
        }

        if (!bankService.hasSufficientFunds(details)) {
            loggerService.log("Insufficient funds");
            throw new IllegalStateException("Not enough funds");
        }

        paymentService.transfer(details);
        loggerService.log("Payment completed");
    }
}
