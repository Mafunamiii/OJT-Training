# Mini Project 1: Calculator

## Description

The developed calculator takes two numbers and one operand per operation.

### Features:
- **Continuous Execution**: Interactive, requires user input to function.
- **Persistent State**: The user can use the previous calculation result as part of the next operation.

## Technologies

- Java 17 (Oracle)
- Maven

## User Guide

Upon running, the program will display a menu that prompts the user to enter their preferred action:
- Selecting **1** will reset the previous result and provide a clean slate for the user.
- Selecting **2** will allow the user to use the previous result as part of a new calculation.

When prompted to enter expressions, the program accepts binary operations in the format "Number Operand Number". If the user selects option **2** from the main menu, the character "**r**" can be used to indicate the use of the previous result.

### Examples of Valid Expressions:
- **n operand n**: Represents numerical values.
- **r operand n**: Uses the result from the previous calculation.
- **n operand r**: Uses the previous result in a new calculation.

### Operand Options:
- Supported operands include: **+**, **-**, **\***, **/**

### Syntax:
n operand n
r operand n
n operand r
