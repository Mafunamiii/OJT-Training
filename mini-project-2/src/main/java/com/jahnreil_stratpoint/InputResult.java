package com.jahnreil_stratpoint;

public class InputResult {
    public int valueInt;
    public boolean isValid;
    public double valueDouble;

    public InputResult(int valueint, boolean isValid, double valuedouble) {
        this.valueInt=valueint;
        this.isValid=isValid;
        this.valueDouble=valuedouble;
    }

    public static InputResult inputCheck (String input, int maxChoice, int inputType) {
        int inputvalueInt = 0;
        boolean isValid = false;
        double inputvalueDouble = 0;

        try {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }

            switch (inputType) {
                case 1: //String input to integer with max value
                    inputvalueInt = Integer.parseInt(input);
                    if (inputvalueInt < 0 || inputvalueInt > maxChoice) {
                        System.out.println("Invalid Input");
                    } else {
                        isValid = true;
                    }
                    break;
                case 2: //String input to integer
                    inputvalueInt = Integer.parseInt(input);
                    break;
                case 3: //String input to double
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
