package com.jahnreil_stratpoint.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type App shutdown hook serves as trigger to log info to logger that the application is shuting down
 */
public class AppShutdownHook extends Thread{
    private static final Logger logger = LoggerFactory.getLogger(AppShutdownHook.class);

    /**
     * run() is overriden to enter log to logger
     */
    @Override
    public void run() {
        logger.info("Application is shutting down");
    }
}
