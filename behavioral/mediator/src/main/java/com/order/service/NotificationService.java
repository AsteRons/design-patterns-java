package com.order.service;

import com.order.model.Order;

public interface NotificationService {
    void notifyCustomer(Order order);
    void notifyFailure(Order order, String reason);
}
