package org.example;

public class Calculator {

    String calculate (char operand, String firstnum, String secondnum) {
        String result = "";

        try {
            switch (operand) {
                case 'n':
                    result = "Syntax Error";
                    break;
                case '*':
                    result = String.valueOf(multiply(Double.valueOf(firstnum), Double.valueOf(secondnum)));
                    break;
                case '/':
                    result = divide(Double.valueOf(firstnum), Double.valueOf(secondnum));
                    break;
                case '+':
                    result = String.valueOf(add(Double.valueOf(firstnum), Double.valueOf(secondnum)));
                    break;
                case '-':
                    result = String.valueOf(subtract(Double.valueOf(firstnum), Double.valueOf(secondnum)));
                    break;
            }
        } catch (Exception e) {
            result = "NaN";
        }

        return result;
    }

    double add (double firstnum, double secondnum) {
        return firstnum + secondnum;
    }

    double subtract (double firstnum, double secondnum) {
        return firstnum - secondnum;
    }

    double multiply (double firstnum, double secondnum) {
        return firstnum  * secondnum;
    }

    String divide (double firstnum, double secondnum) {
        double result;
        try {
            result = firstnum / secondnum;
        } catch (Exception e) {

            return "NaN";
        }
        return String.valueOf(result);
    }
}
