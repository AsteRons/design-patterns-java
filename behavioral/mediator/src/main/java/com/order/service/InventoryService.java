package com.order.service;

import com.order.exception.OutOfStockException;
import com.order.model.Product;

import java.util.List;

public interface InventoryService {
    void reserveProducts(List<Product> products) throws OutOfStockException;
}
