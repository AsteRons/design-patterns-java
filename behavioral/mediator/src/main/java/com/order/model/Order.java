package com.order.model;


import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class Order {
    private final String orderId = UUID.randomUUID().toString();
    private final String customerEmail;
    private final List<Product> products;
}