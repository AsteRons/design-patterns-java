package com.payment.factory;


import com.payment.domain.FraudCheckService;
import com.payment.domain.PaymentService;
import com.payment.domain.RefundService;
import com.payment.domain.CurrencyConverterService;


public class PaymentFacade {

    private final PaymentService paymentService;
    private final RefundService refundService;
    private final FraudCheckService fraudCheckService;
    private final CurrencyConverterService currencyConverterService;

    public PaymentFacade(PaymentProviderFactory factory) {
        this.paymentService = factory.createPaymentService();
        this.refundService = factory.createRefundService();
        this.fraudCheckService = factory.createFraudCheckService();
        this.currencyConverterService = factory.createCurrencyConverterService();
    }

    public void pay(String userId, double amount, String currency) {
        if (!fraudCheckService.checkFraud(userId, amount)) {
            throw new RuntimeException("Fraud detected for user: " + userId);
        }
        double converted = currencyConverterService.convert(amount, currency, "USD");
        paymentService.processPayment(converted, "USD");
    }

    public void refund(String transactionId) {
        refundService.refund(transactionId);
    }
}
