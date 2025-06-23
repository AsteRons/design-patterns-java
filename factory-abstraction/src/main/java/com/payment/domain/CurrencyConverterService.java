package com.payment.domain;

public interface CurrencyConverterService {
    double convert(double amount, String fromCurrency, String toCurrency);
}
