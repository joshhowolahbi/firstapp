package com.spring.firstapp.kafka;

import com.spring.firstapp.model.FirstAppEvent;
import com.spring.firstapp.services.FirstAppEventHandler;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class EventConsumer {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EventConsumer.class);
    private final FirstAppEventHandler eventHandler;

    public EventConsumer(FirstAppEventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    @KafkaListener(
            topics = "${messaging.topic.inbound}",
            containerFactory = "firstAppContainerFactory"
    )
    public void consume(FirstAppEvent firstAppEvent) {
        LOGGER.info("Successfully consumed event with header={} and payload={}", firstAppEvent.getHeader(), firstAppEvent.getPayload());
        eventHandler.handle(firstAppEvent);
    }
}
