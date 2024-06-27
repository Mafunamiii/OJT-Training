package com.jahnreil_stratpoint.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * inputCheck class validates and clean the user input
 */
@Getter
@Setter
@AllArgsConstructor
public class InputCheck {
    private static final Logger logger = LoggerFactory.getLogger(InputCheck.class);

    /**
     * int valueInt stores the input in int
     */
    private int valueInt;
    /**
     * boolean isValid indicates if the inputStr is a valid input
     */
    private boolean isValid;
    /**
     * double valueDouble stores the input in double
     */
    private double valueDouble;

    /**
     * Input check values input check.
     *
     * @param inputStr  the input str receives the inputstr in its raw values
     * @param maxChoice the max choice accepts the max choice in which the inputStr will be compared to, can be set to 0 if inputType is TO_DOUBLE
     * @param inputType the input type accepts enum InputType: INT_WITH_MAX_CHOICE, INT_ONLY, and TO_DOUBLE only
     * @return the input check
     */
    public static InputCheck inputCheckValues (String inputStr, int maxChoice, InputType inputType) {
        int inputValueInt = 0;
        boolean inputIsValid = false;
        double inputValueDouble = 0.0;

        try {
            if (inputStr.isEmpty()) {
                logger.error("InputStr cannot be empty");
                throw new IllegalArgumentException("Input cannot be empty");
            }

            switch (inputType) {
                case INT_WITH_MAX_CHOICE: // String input to integer with max value
                    logger.info("Converting InputStr to int and comparing to max choice");
                    inputValueInt = Integer.parseInt(inputStr);
                    if (inputValueInt < 0 || inputValueInt > maxChoice) {
                        logger.error("Input Value is higher than max choice indicated");
                        System.out.println("Invalid Input");
                    } else {
                        logger.info("InputStr to int convert successful");
                        inputIsValid = true;
                    }
                    break;
                case INT_ONLY: // String input to integer
                    logger.info("Converting InputStr to int");
                    inputValueInt = Integer.parseInt(inputStr);
                    break;
                case TO_DOUBLE: // String input to double
                    logger.info("Converting InputStr to double");
                    inputValueDouble = Double.parseDouble(inputStr);
                    break;
            }

        } catch (NumberFormatException e) {
            logger.error("Error {}", e);
            System.out.println("Invalid Input, select from the choices");

        } catch (IllegalArgumentException e) {
            logger.error("Error {}", e);
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Error {}", e);
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        logger.info("returning inputCheck");
        return new InputCheck(inputValueInt, inputIsValid, inputValueDouble);
    }
}
