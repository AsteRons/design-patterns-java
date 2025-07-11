package com.order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class Product {

    private final String sku;
    private final int quantity;
    private final double price;

    public Product deepCopy() {
        return new Product(sku, quantity, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return quantity == product.quantity &&
                Double.compare(product.price, price) == 0 &&
                Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, quantity, price);
    }
}
