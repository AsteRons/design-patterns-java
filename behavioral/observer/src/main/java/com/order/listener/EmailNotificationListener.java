package com.order.listener;

import com.order.model.OrderStatusChangedEvent;

public class EmailNotificationListener implements OrderStatusChangeListener {

    @Override
    public void onStatusChanged(OrderStatusChangedEvent event) {
        System.out.printf("Email to %s: Order %s changed from %s to %s%n",
                event.getOrder().getCustomerEmail(),
                event.getOrder().getId(),
                event.getOldStatus(),
                event.getNewStatus());
    }
}
