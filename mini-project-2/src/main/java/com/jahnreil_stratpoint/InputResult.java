package com.jahnreil_stratpoint;

/**
 * Represents the result of an input validation operation.
 * Contains information about the validated input value, validity status,
 * and optionally a double value.
 */
public class InputResult {
    public int valueInt;
    public boolean isValid;
    public double valueDouble;

    /**
     * Constructs an InputResult object with specified values.
     *
     * @param valueInt    The validated integer value from the input.
     * @param isValid     Boolean indicating whether the input is valid.
     * @param valueDouble Optional double value from the input (default: 0 if not applicable).
     */
    public InputResult(int valueInt, boolean isValid, double valueDouble) {
        this.valueInt = valueInt;
        this.isValid = isValid;
        this.valueDouble = valueDouble;
    }

    /**
     * Validates user input based on specified criteria.
     *
     * @param input      The input string to be validated.
     * @param maxChoice  Maximum allowed value or range for validation.
     * @param inputType  Type of input validation to perform:
     *                   1 - Convert string to integer with maximum value check,
     *                   2 - Convert string to integer,
     *                   3 - Convert string to double.
     * @return InputResult object containing validated values and validity status.
     */
    public static InputResult inputCheck(String input, int maxChoice, int inputType) {
        int inputvalueInt = 0;
        boolean isValid = false;
        double inputvalueDouble = 0;

        try {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }

            switch (inputType) {
                case 1: // String input to integer with max value
                    inputvalueInt = Integer.parseInt(input);
                    if (inputvalueInt < 0 || inputvalueInt > maxChoice) {
                        System.out.println("Invalid Input");
                    } else {
                        isValid = true;
                    }
                    break;
                case 2: // String input to integer
                    inputvalueInt = Integer.parseInt(input);
                    break;
                case 3: // String input to double
                    inputvalueDouble = Double.parseDouble(input);
                    break;
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid Input, select from the choices");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        return new InputResult(inputvalueInt, isValid, inputvalueDouble);
    }

}
