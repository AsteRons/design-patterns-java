package com.order.service;

import com.order.model.Order;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotificationService implements NotificationService {
    @Override
    public void notifyCustomer(Order order) {
        log.info("Sending confirmation email to {}", order.getCustomerEmail());
    }

    @Override
    public void notifyFailure(Order order, String reason) {
        log.warn("Notifying customer {} of failure: {}", order.getCustomerEmail(), reason);
    }
}
