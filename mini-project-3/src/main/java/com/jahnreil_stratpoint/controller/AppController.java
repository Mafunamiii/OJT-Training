package com.jahnreil_stratpoint.controller;

import com.jahnreil_stratpoint.util.AppShutdownHook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The main AppController to run E-Commerce application
 */
public class AppController
{
    private static final Logger logger = LoggerFactory.getLogger(AppController.class);

    /**
     * The entry point of application. runs and starts e-commerce controller
     *
     * @param args the input arguments
     */
    public static void main( String[] args )
    {
        Runtime.getRuntime().addShutdownHook(new AppShutdownHook());

        logger.info("Started main");
        ECommerceController eCommerceController = new ECommerceController();
        logger.info("Created eCommerceController");
        eCommerceController.startECommerceController();
        logger.info("Started eCommerceController.startECommerceController()");


        logger.info("Application Execution Terminated");
    }
}
