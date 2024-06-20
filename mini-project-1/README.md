Mini Project 1: Calculator

Description: 
    The developed calculator takes two numbers and one operand per operation. 

    Features:
        - Continuous Execution.
        - Interactive, requires user input to function.
        - Persistent State, the user can use previous calculation result as part of the next operation.
    
Technologies:
    Java 17 (Oracle)
    Maven

User Guide
Upon running, the program will display a menu that will prompt the user to enter their preferred action.
Selecting 1 will reset previous result and will provide a clean slate for the user
Selecting 2 will allow the user to use previous result as part of the new calculation

When prompted to enter expressions, the program will only accept binary operations consisting of "Number Operand Number". In the event that the user will select 2 from the main menu, the character "r" can be used to indicate the use of the previous result. 

Examples of valid expressions are as follows:
n represents numerical values
r represents result from previous calculation
operand include '+', '-', '*', '/'

syntax: 
    n operand n
    r operand n
    n operand r
    

