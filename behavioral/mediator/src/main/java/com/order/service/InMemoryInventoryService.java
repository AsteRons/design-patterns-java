package com.order.service;

import com.order.exception.OutOfStockException;
import com.order.model.Product;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class InMemoryInventoryService implements InventoryService {
    @Override
    public void reserveProducts(List<Product> products) throws OutOfStockException {
        for (Product product : products) {
            log.info("Checking stock for {}", product.getSku());
            if (product.getQuantity() > 10) { // Simulated logic
                throw new OutOfStockException("Insufficient stock for SKU: " + product.getSku());
            }
        }
        log.info("All products reserved.");
    }
}
