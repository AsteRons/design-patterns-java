package com.payment.facade.model;

public class PaymentDetails {
    private String accountFrom;
    private String accountTo;
    private double amount;

    public PaymentDetails(String accountFrom, String accountTo, double amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
    }


    public String getAccountFrom() { return accountFrom; }
    public String getAccountTo() { return accountTo; }
    public double getAmount() { return amount; }
}
