package com.jahnreil_stratpoint.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * InputCheck class validates and cleans user input.
 * @param <T> Type of the input value (can be Integer, Double, etc.)
 */
@Getter
@Setter
@AllArgsConstructor
public class InputCheck<T> {
    private static final Logger logger = LoggerFactory.getLogger(InputCheck.class);

    private T value;      // Generic type for input value
    private boolean isValid;

    /**
     * Validates and converts input string to the specified type.
     *
     * @param inputStr  the input string to validate and convert
     * @param maxChoice the maximum allowed value for integer inputs
     * @param inputType the type of input (INT_WITH_MAX_CHOICE, INT_ONLY, TO_DOUBLE)
     * @return the input check result containing the converted value and validation status
     */
    public static <T> InputCheck<T> inputCheckValues(String inputStr, int maxChoice, InputType inputType) {
        T inputValue = null;
        boolean inputIsValid = false;

        try {
            if (inputStr.isEmpty()) {
                logger.error("InputStr cannot be empty");
                throw new IllegalArgumentException("Input cannot be empty");
            }

            switch (inputType) {
                case INT_WITH_MAX_CHOICE:
                    if (Integer.class.equals(inputValue.getClass())) {
                        logger.info("Converting InputStr to int and comparing to max choice");
                        inputValue = (T) Integer.valueOf(inputStr);
                        if ((Integer) inputValue < 0 || (Integer) inputValue > maxChoice) {
                            logger.error("Input Value is higher than max choice indicated");
                            System.out.println("Invalid Input");
                        } else {
                            logger.info("InputStr to int convert successful");
                            inputIsValid = true;
                        }
                    }
                    break;
                case INT_ONLY:
                    if (Integer.class.equals(inputValue.getClass())) {
                        logger.info("Converting InputStr to int");
                        inputValue = (T) Integer.valueOf(inputStr);
                    }
                    break;
                case TO_DOUBLE:
                    if (Double.class.equals(inputValue.getClass())) {
                        logger.info("Converting InputStr to double");
                        inputValue = (T) Double.valueOf(inputStr);
                    }
                    break;
            }

        } catch (NumberFormatException e) {
            logger.error("Error {}", e);
            System.out.println("Invalid Input, select from the choices");

        } catch (IllegalArgumentException e) {
            logger.error("Error {}", e);
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage(), e);
            e.printStackTrace();
        }
        logger.info("Returning inputCheck");
        return new InputCheck<>(inputValue, inputIsValid);
    }
}
