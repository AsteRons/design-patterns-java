package com.order.service;

import com.order.exception.PaymentFailedException;
import com.order.model.Order;

public interface PaymentService {
    void charge(Order order) throws PaymentFailedException;
}