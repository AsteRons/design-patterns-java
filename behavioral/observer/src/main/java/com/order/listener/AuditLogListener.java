package com.order.listener;

import com.order.listener.OrderStatusChangeListener;
import com.order.model.OrderStatusChangedEvent;

public class AuditLogListener implements OrderStatusChangeListener {
    @Override
    public void onStatusChanged(OrderStatusChangedEvent event) {
        System.out.printf("Audit: Order %s status changed from %s to %s%n",
                event.getOrder().getId(),
                event.getOldStatus(),
                event.getNewStatus());
    }
}
