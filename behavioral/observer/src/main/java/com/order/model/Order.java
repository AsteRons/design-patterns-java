package com.order.model;


import com.order.model.OrderStatusChangedEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class Order {
    private String id;
    private String customerEmail;
    private String status;

    private transient OrderStatusEventDispatcher dispatcher;

    public void setStatus(String newStatus) {
        if (!newStatus.equals(this.status)) {
            String oldStatus = this.status;
            this.status = newStatus;

            if (dispatcher != null) {
                dispatcher.dispatch(new OrderStatusChangedEvent(this, oldStatus, newStatus));
            }
        }
    }

    public void setDispatcher(OrderStatusEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }
}