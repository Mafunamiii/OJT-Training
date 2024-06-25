package com.Jahnreil_Stratpoint;

public class InputResult {
    public int valueInt;
    public boolean isValid;

    public InputResult(int value, boolean isValid) {
        this.valueInt=value;
        this.isValid=isValid;
    }

    public static InputResult inputCheck (String input, int maxChoice) {
        int inputvalue = 0;
        boolean isValid = false;

        try {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }
            inputvalue = Integer.parseInt(input);
            if (inputvalue < 0 || inputvalue > maxChoice) {
                System.out.println("Invalid Input");
            } else {
                isValid = true;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input, select from the choices");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }

        return new InputResult(inputvalue, isValid);
    }
}
