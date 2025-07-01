package com.payment.domain;

public interface FraudCheckService {
    boolean checkFraud(String userId, double amount);
}
