package com.order.listener;

import com.order.model.OrderStatusChangedEvent;

public interface OrderStatusChangeListener {
    void onStatusChanged(OrderStatusChangedEvent event);
}
