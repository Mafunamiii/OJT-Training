package org.example;

import java.util.Scanner;

/*
    isOperand (Boolean) : checks if the character is part of the operands in the scope of the calculator
    parseInput (String[]) : checks if the user inputs are valid. If the inputs are valid, the appropriate variables
                            will be assigned to the return string array, this return string array will be used in the Calculator
    calculatorApp (void) : consists of the main processes of the calculator

 */

public class Main {

    public static void main(String[] args) {
        calculatorApp();
    }

    static boolean isOperand(char operand) {
        return operand == '+' || operand == '-' || operand == '/' || operand == '*';
    }



    static String[] parseInput(String input, String result) {
        String firstNum = "", secondNum = "";
        String operand = "n";
        String[] parsedInput = new String[3];

        for (char inputChar : input.toCharArray()) {
            if (!isOperand(inputChar) && operand.equals("n")) {
                if (Character.toLowerCase(inputChar) == 'r') {
                    firstNum += result;
                } else {
                    firstNum += inputChar;
                }
            } else if (isOperand(inputChar)) {
                operand = String.valueOf(inputChar);
            } else if (!isOperand(inputChar) && !operand.equals("n")) {
                if (Character.toLowerCase(inputChar) == 'r') {
                    secondNum += result;
                } else {
                    secondNum += inputChar;
                }
            }
        }

        parsedInput[0] = firstNum;
        parsedInput[1] = operand;
        parsedInput[2] = secondNum;

        return parsedInput;
    }

    static void calculatorApp() {
        Calculator calc = new Calculator();
        String result = "";
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            String input = "";
            String[] parsedInput = new String[3];

            System.out.print(
                    "============================================================\n" +
                    "                    Binary Calculator\n" +
                    "                     Select action:\n\n" +
                    "         [1] New\n" +
                    "         [2] Perform operation using previous result\n" +
                    "         [3] exit                                           \n" +
                    "============================================================\n" +
                    " ►"
            );

            char menuInput = inputScanner.nextLine().charAt(0);

            if (menuInput == '1' || menuInput == '2') {
                switch (menuInput) {
                    case '1':
                        result = "";
                        System.out.print("\nEnter Binary Operation\n(ex. number operand number) \n► ");
                        input = inputScanner.nextLine();
                        parsedInput = parseInput(input, result);
                        break;
                    case '2':
                        System.out.print("\nTo perform operation with previous result, use 'r' to represent previous result\n" +
                                "(ex. r + 2 or 200 / r)\n► "
                        );
                        input = inputScanner.nextLine();
                        parsedInput = parseInput(input, result);
                        break;
                }

                result = calc.calculate(parsedInput[1].charAt(0), parsedInput[0], parsedInput[2]);
                if (result.equals("NaN")) {
                    System.out.println("Syntax Error! Try again.\n");
                    continue;
                }
                System.out.println("Result: " + result);
            } else if (menuInput == '3') {
                System.out.println("Exiting Program");
                break;
            }
            else {
                System.out.println("Invalid input, please enter from the given choices only\n");
            }
        }
    }
}
