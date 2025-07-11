package com.order.dispatcher;

import com.order.listener.OrderStatusChangeListener;
import com.order.model.OrderStatusChangedEvent;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusEventDispatcher {
    private final List<OrderStatusChangeListener> listeners = new ArrayList<>();

    public void register(OrderStatusChangeListener listener) {
        listeners.add(listener);
    }

    public void unregister(OrderStatusChangeListener listener) {
        listeners.remove(listener);
    }

    public void dispatch(OrderStatusChangedEvent event) {
        for (OrderStatusChangeListener listener : listeners) {
            listener.onStatusChanged(event);
        }
    }
}
