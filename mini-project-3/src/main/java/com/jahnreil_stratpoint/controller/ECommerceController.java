package com.jahnreil_stratpoint.controller;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type E commerce controller.
 */
@NoArgsConstructor
public class ECommerceController {
    private static final Logger logger = LoggerFactory.getLogger(MainMenuController.class);

    private static MainMenuController mainMenuController = new MainMenuController();
    private static ProductShelfController productShelfController = new ProductShelfController();

    /**
     * Start e commerce controller.
     */
    public void startECommerceController() {
        while (true) {
            int mainMenuChoice = mainMenuController.menuChoice();

            switch (mainMenuChoice) {
                case 1:
                    logger.info("View Product Shelf, main menu choice: {}", mainMenuChoice);

                    break;
                case 2:
                    logger.info("View Cart, main menu choice: {}", mainMenuChoice);

                    break;
                case 3:
                    logger.info("Exiting program, main menu choice: {}", mainMenuChoice);
                    System.out.println("Exiting Program");
                    return;
            }
        }
    }
}
