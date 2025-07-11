package com.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
@AllArgsConstructor
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<Product> products;

    public static Order createNew(String customerEmail, List<Product> products) {
        return new Order(UUID.randomUUID().toString(), customerEmail, List.copyOf(products));
    }

    public double getTotalAmount() {
        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public Order deepCopy() {
        List<Product> copiedProducts = products.stream()
                .map(Product::deepCopy)
                .collect(Collectors.toList());
        return new Order(id, customerEmail, copiedProducts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;
        return Objects.equals(id, order.id) &&
                Objects.equals(customerEmail, order.customerEmail) &&
                Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerEmail, products);
    }
}
