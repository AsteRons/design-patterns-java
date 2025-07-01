package com.ordersystem.model;

import java.util.Objects;

public final class Item {
    private final String productId;
    private final int quantity;
    private final double price;

    public Item(String productId, int quantity, double price) {
        this.productId = Objects.requireNonNull(productId, "ProductId required");
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
