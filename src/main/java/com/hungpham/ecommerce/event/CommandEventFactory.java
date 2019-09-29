package com.hungpham.ecommerce.event;

import com.lmax.disruptor.EventFactory;
import org.springframework.stereotype.Component;

@Component
public class CommandEventFactory implements EventFactory<CommandEvent> {

    @Override
    public CommandEvent newInstance() {
        return new CommandEvent();
    }
}
