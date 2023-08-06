package com.spring.firstapp.services;


import com.spring.firstapp.model.FirstAppEvent;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FirstAppEventHandler {
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(FirstAppEventHandler.class);

    public FirstAppEventHandler() {
    }

    public void handle(FirstAppEvent event) {
        LOGGER.info("Received event to handle. event:{}", event);

        //handle

        LOGGER.info("Successfully handled event.");
    }
}
