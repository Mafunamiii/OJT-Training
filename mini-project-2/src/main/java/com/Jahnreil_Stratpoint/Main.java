package com.Jahnreil_Stratpoint;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static Scanner inScanner = new Scanner(System.in);
    static ManageBook manageBooks;
    static loadBooks loadBooks;

    public static void main(String[] args) {
        manageBooks = new ManageBook(bookList);
        loadBooks =  new loadBooks(bookList,manageBooks);
        bookList = loadBooks.loadToList();
        libraryManagement();
    }

    static void libraryManagement() {

        boolean runLibManage = true;
        while (runLibManage) {
            int choice = mainMenu();
            System.out.println("choice: "  + choice);
            switch (choice){
                case 1:
                    manageBooks.retrieveBooks(bookList);
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    manageBooks.searchBook(bookList);
                    break;
                case 5:
                    System.out.println("Exiting program");
                    runLibManage = false;
                    break;
            }
        }

    }

    static int mainMenu() {
        int menuChoice = 0;
        inputLoop:
        while (true) {
            System.out.print(
                    "\n\n==========================================\n" +
                            "       Library Management System\n" +
                            "          [1] Browse Catalog\n"+
                            "          [2] Add Book\n"+
                            "          [3] Remove Book\n"+
                            "          [4] Search Book\n"+
                            "          [5] Exit\n►");

            String inputStr = inScanner.nextLine();
            menuChoice = inputCheck(inputStr, 5);
            break inputLoop;
        }
        return menuChoice;
    }

    public static int inputCheck (String input, int maxChoice) {
        int inputStr = 0;
        try {
            if (input.isEmpty()) {
                throw new IllegalArgumentException("Input cannot be empty");
            }
            inputStr = Integer.parseInt(input);
            if (inputStr < 0 || inputStr > maxChoice) {
                System.out.println("Invalid Input, select from the choices");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Input, select from the choices");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        return inputStr;
    }


}