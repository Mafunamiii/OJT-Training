package com.jahnreil_stratpoint;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static Scanner inScanner = new Scanner(System.in);
    static ManageBook manageBooks;
    static loadBooks loadBooks;
    private boolean isValid;
    private int value;

    public static void main(String[] args) {
        manageBooks = new ManageBook(bookList);
        loadBooks =  new loadBooks(bookList,manageBooks);
        bookList = loadBooks.loadFromCSV();
        libraryManagement();
    }

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