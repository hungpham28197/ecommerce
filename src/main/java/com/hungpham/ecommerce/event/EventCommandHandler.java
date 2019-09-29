package com.hungpham.ecommerce.event;


import com.lmax.disruptor.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventCommandHandler<T> implements EventHandler<CommandEvent> {
    private static final Logger logger = LoggerFactory.getLogger(EventCommandHandler.class);
    public static final int SAVE = 1;
    public static final int UPDATE = 2;
    public static final int DELETE = 3;

    void router(Command command) {
        int type = command.getType();
        T t = (T) command.getBody();
        switch (type) {
            case SAVE: {
                logger.info("----> Command Type is SAVE");
                command.getPersistent().save(t);
                logger.info("----> Insert done!!!");
                break;
            }
            case UPDATE: {
                logger.info("Command Type is UPDATE");
                command.getPersistent().save(t);
                break;
            }
            case DELETE: {
                logger.info("Command Type is DELETE");
                command.getPersistent().delete(t);
                break;
            }
            default:
                logger.error("----> Handler Command To DB Failed!!");
        }
    }

    @Override
    public void onEvent(CommandEvent commandEvent, long sequence, boolean endOfBatch) throws Exception {
        router(commandEvent.getCommand());
    }
}
