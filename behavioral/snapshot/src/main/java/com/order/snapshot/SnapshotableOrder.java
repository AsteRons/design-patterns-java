package com.order.snapshot;


import com.order.model.Order;
import com.order.snapshot.OrderSnapshot;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnapshotableOrder {
    private Order order;

    public SnapshotableOrder(Order order) {
        this.order = order;
    }

    public OrderSnapshot createSnapshot() {
        return new OrderSnapshot(order.deepCopy());
    }

    public void restore(OrderSnapshot snapshot) {
        this.order = snapshot.getOrder();
    }
}
