package com.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String sku;
    private int quantity;
    private double unitPrice;
}