package com.order.service;

import com.order.exception.PaymentFailedException;
import com.order.model.Order;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class PayPalPaymentService implements PaymentService {
    @Override
    public void charge(Order order) throws PaymentFailedException {
        log.info("Charging customer for order: {}", order.getOrderId());
        if (order.getProducts().size() > 3) {
            throw new PaymentFailedException("Payment declined: suspicious activity.");
        }
        log.info("Payment successful.");
    }
}
