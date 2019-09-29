package com.hungpham.ecommerce.event;

import java.util.UUID;

public class CommandEvent {
    private String id = UUID.randomUUID().toString();
    private Command command;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
