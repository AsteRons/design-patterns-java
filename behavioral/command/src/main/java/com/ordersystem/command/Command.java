package com.ordersystem.command;

public interface Command {
    void execute();
    void undo();
}
