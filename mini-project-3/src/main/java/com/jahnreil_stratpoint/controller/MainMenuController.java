package com.jahnreil_stratpoint.controller;

import com.jahnreil_stratpoint.util.InputCheck;
import com.jahnreil_stratpoint.util.InputType;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

/**
 * The type Main menu controller handles the main menu processes which returns an int value to ECommerceController
 */
@NoArgsConstructor
public class MainMenuController {
    private static final Logger logger = LoggerFactory.getLogger(MainMenuController.class);
    /**
     * public scanner inputscan that can be used throughout the entire application
     * */
    public static Scanner inputscan = new Scanner(System.in);

    /**
     * Menu choice int
     * @return the int menuChoiceResult
     */
    public int menuChoice() {
        int menuChoiceResult = 0;
        logger.info("Started menuChoice()");
        while (true) {
            System.out.print(
                    """
                    \n==========================================
                    
                                    JG Market
                              [1] Browse Products
                              [2] View Cart
                              [3] Exit Program
                              
                    ==========================================
                    ► """);
            String input = inputscan.nextLine();
            InputCheck inputCheck = InputCheck.inputCheckValues(input, 3, InputType.INT_WITH_MAX_CHOICE);

            if (inputCheck.isValid()) {
                logger.info("menuChoice valid. Selected menu choice: {}", inputCheck.getValue());
                menuChoiceResult = (Integer) inputCheck.getValue();
                break;
            } else {
                logger.warn("Invalid menuChoice input: {}", input);
            }
        }
        logger.info("Returning menuChoiceResult {}", menuChoiceResult);
        return menuChoiceResult;
    }
}
