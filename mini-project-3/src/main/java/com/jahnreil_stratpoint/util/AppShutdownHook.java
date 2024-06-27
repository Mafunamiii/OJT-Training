package com.jahnreil_stratpoint.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type App shutdown hook.
 */
public class AppShutdownHook extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(AppShutdownHook.class);

    @Override
    public void run() {
        logger.info("Application is shutting down");
    }
}
