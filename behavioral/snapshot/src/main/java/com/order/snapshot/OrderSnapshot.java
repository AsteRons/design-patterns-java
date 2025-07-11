package com.order.snapshot;


import com.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderSnapshot {
    private final Order order;
}
