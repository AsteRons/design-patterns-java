package com.ordersystem.invoker;

import com.ordersystem.command.Command;

import java.util.Stack;

public class OrderInvoker {

    private final Stack<Command> history = new Stack<>();
    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        } else {
            System.out.println("No commands to undo.");
        }
    }
}
