package com.order.prototype;

import java.util.ArrayList;
import java.util.List;

public class Order implements Prototype<Order> {
    private String customerName;
    private List<String> items;
    private double total;

    public Order(String customerName) {
        this.customerName = customerName;
        this.items = new ArrayList<>();
    }

    public void addItem(String item, double price) {
        items.add(item);
        total += price;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotal() {
        return total;
    }

    public List<String> getItems() {
        return items;
    }

    @Override
    public Order clone() {
        Order cloned = new Order(this.customerName);
        cloned.items = new ArrayList<>(this.items);
        cloned.total = this.total;
        return cloned;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerName='" + customerName + '\'' +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
