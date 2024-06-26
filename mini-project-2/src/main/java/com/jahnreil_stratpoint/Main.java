package com.jahnreil_stratpoint;

import java.util.ArrayList;
import java.util.Scanner;

/*
    void main(String[] args) = where library Management is run
    void libraryManagemetn() = contain the abstract processes and calls the necessary methods depending on user choice
    int mainMenu() = returns the user choice from the main menu
 */

public class Main {
    static ArrayList<Book> bookList = new ArrayList<>();
    static Scanner inScanner = new Scanner(System.in);
    static ManageBook manageBooks;
    static loadBooks loadBooks;


    /**
     * void main(String[] args) = where library Management is run
     * Initializes necessary components and starts the library management system.
     */

    public static void main(String[] args) {
        manageBooks = new ManageBook(bookList);
        loadBooks =  new loadBooks(bookList,manageBooks);
        bookList = loadBooks.loadFromCSV();
        libraryManagement();
    }

    /**
     * void libraryManagement() = contain the abstract processes and calls the necessary methods depending on user choice
     * Manages the library operations based on user input by invoking corresponding methods from ManageBook.
     */

    static void libraryManagement() {

        boolean runLibManage = true;
        while (runLibManage) {
            int choice = mainMenu();

            switch (choice){
                case 1:
                    manageBooks.retrieveBooks(bookList);
                    break;
                case 2:
                    manageBooks.addBook(bookList);
                    break;
                case 3:
                    manageBooks.removeBookById(bookList);
                    break;
                case 4:
                    manageBooks.searchBook(bookList);
                    break;
                case 5:
                    manageBooks.viewBook(bookList);
                    break;
                case 6:
                    System.out.println("Exiting program");
                    runLibManage = false;
                    break;
            }
        }

    }

    /**
     * int mainMenu() = returns the user choice from the main menu
     * Displays the main menu of the library management system and retrieves user input for menu selection.
     * @return The user's menu choice as an integer.
     */

    static int mainMenu() {
        int menuChoice = 0;
        inputLoop:
        while (true) {
            System.out.print("""
                            
                            ==========================================
                                    Library Management System
                                    [1] Browse Catalog
                                    [2] Add Book
                                    [3] Remove Book
                                    [4] Search Book
                                    [5] View Book Details
                                    [6] Exit
                            ►"""
            );

            String inputStr = inScanner.nextLine();
            InputResult inputResult = InputResult.inputCheck(inputStr,6,1);
            if (inputResult.isValid) {
                menuChoice = inputResult.valueInt;
                break;
            }
            break;
        }
        return menuChoice;
    }

}