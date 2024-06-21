package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static Scanner inScanner = new Scanner(System.in);
    static ManageBook manageBooks;



    public static void main(String[] args) {
        manageBooks = new ManageBook(bookList);
        manageBooks.addBook("Book 1", "ISBN001");
        manageBooks.addBook("Book 2", "ISBN002");
        manageBooks.addBook("Book 3", "ISBN003");
        manageBooks.addBook("Book 4", "ISBN004");
        manageBooks.addBook("Book 5", "ISBN005");
        manageBooks.addBook("Book 6", "ISBN006");
        manageBooks.addBook("Book 7", "ISBN007");

        manageBooks.addHardBack(new Book("HardBack 1", "ISBNH001"), 200);
        manageBooks.addHardBack(new Book("HardBack 2", "ISBNH002"), 250);
        manageBooks.addHardBack(new Book("HardBack 3", "ISBNH003"), 180);
        manageBooks.addHardBack(new Book("HardBack 4", "ISBNH004"), 300);
        manageBooks.addHardBack(new Book("HardBack 5", "ISBNH005"), 220);
        manageBooks.addHardBack(new Book("HardBack 6", "ISBNH006"), 270);
        manageBooks.addHardBack(new Book("HardBack 7", "ISBNH007"), 190);

        libraryManagement();
    }

    static void libraryManagement() {
        int choice = mainMenu();

        switch (choice){
            case 1:
                manageBooks.retrieveBooks();
                break;
           case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:


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
            int temp = inputCheck(inputStr, 5);
            if (temp != 0) {
                menuChoice = temp;
                break;
            }
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