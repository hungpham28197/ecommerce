package com.hungpham.ecommerce.event;

import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.util.DaemonThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CommandEventProducer {
    private final CommandEventFactory factory;
    private final EventCommandHandler eventCommandHandler;
    Disruptor<CommandEvent> disruptor;

    @PostConstruct
    private void init(){
        disruptor.handleEventsWith(eventCommandHandler);
        // Start the Disruptor, starts all threads running
        disruptor.start();
    }

    @Autowired
    public CommandEventProducer(CommandEventFactory factory, EventCommandHandler eventCommandHandler) {
        disruptor= new Disruptor<>(factory, 1024, DaemonThreadFactory.INSTANCE);
        this.eventCommandHandler = eventCommandHandler;
        this.factory = factory;
    }

    public void onData(Command command)
    {
        long sequence = disruptor.getRingBuffer().next();  // Grab the next sequence
        try
        {
            CommandEvent event = disruptor.getRingBuffer().get(sequence); // Get the entry in the Disruptor
            // for the sequence
           event.setCommand(command);
        }
        finally
        {
            disruptor.getRingBuffer().publish(sequence);
        }
    }
}
