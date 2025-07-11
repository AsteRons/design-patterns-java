package com.order.snapshot;

import com.order.snapshot.OrderSnapshot;
import com.order.snapshot.SnapshotableOrder;

import java.util.Stack;

public class OrderCaretaker {
    private final Stack<OrderSnapshot> history = new Stack<>();

    public void backup(SnapshotableOrder order) {
        history.push(order.createSnapshot());
    }

    public void undo(SnapshotableOrder order) {
        if (!history.isEmpty()) {
            order.restore(history.pop());
        }
    }

    public boolean hasHistory() {
        return !history.isEmpty();
    }
}