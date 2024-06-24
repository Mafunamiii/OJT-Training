package com.example;

import java.util.ArrayList;
import java.util.Objects;

public class ManageBook {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    public ManageBook (ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

   public void addBook(String title, String isbn) {
        bookList.add(new Book(title,isbn));
    }

    public void addBook(String title,String author, String isbn) {
        bookList.add(new Book(title, author, isbn));
    }

    public void addHardBack(Book book, int pagecount) {
        bookList.add(new Book.hardBack(
                book.getTitle(),
                book.getISBN(),
                pagecount
        ));
    }

    public void addHardBack(Book book, String coverType, int pageCount, double weightKG) {
        bookList.add(new Book.hardBack(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN(),
                book.getGenre(),
                book.getPublisher(),
                book.getPublicationDate(),
                book.getSynopsis(),
                book.getLanguage(),
                coverType,
                pageCount,
                weightKG
        ));
    }

    public void addEBook(Book book, String fileFormat, double fileSize) {
        bookList.add(new Book.eBook(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN(),
                book.getGenre(),
                book.getPublisher(),
                book.getPublicationDate(),
                book.getSynopsis(),
                book.getLanguage(),
                fileFormat,
                fileSize
        ));
    }

    public void addEBook(Book book, String fileFormat) {
        bookList.add(new Book.eBook(
                book.getTitle(),
                book.getISBN(),
                fileFormat
        ));
    }



    public void addAudioBook(Book book, String fileFormat, double fileSize, String audioFormat, String bitrate) {
        bookList.add(new Book.audioBook(
                book.getTitle(),
                book.getAuthor(),
                book.getISBN(),
                book.getGenre(),
                book.getPublisher(),
                book.getPublicationDate(),
                book.getSynopsis(),
                book.getLanguage(),
                fileFormat,
                fileSize,
                audioFormat,
                bitrate
        ));
    }

    public void addAudioBook(Book book, String fileFormat, String audioFormat, String bitrate) {
        bookList.add(new Book.audioBook(
                book.getTitle(),
                book.getISBN(),
                fileFormat,
                audioFormat,
                bitrate
        ));
    }

    static void addAudioBook(Book book, String fileFormat, String audioFormat) {
        bookList.add(new Book.audioBook(
                book.getTitle(),
                book.getISBN(),
                fileFormat,
                audioFormat
        ));
    }

    // ==========================================

    static void removeBook(String isbn) {

    }

    // ==========================================

    public void searchBook(ArrayList<Book> bookList) {
        ArrayList<Book> results = new ArrayList<>();

        searchbook:
        while (true) {
            System.out.print(
                    "\n============== Search by? ==============\n" +
                            "            [1] Title\n"+
                            "            [2] Author\n"+
                            "            [3] ISBN\n"+
                            "            [4] Genre\n"+
                            "            [5] Publisher\n"+
                            "            [6] Language\n►");
            String input = Main.inScanner.nextLine();
            int choice = Main.inputCheck(input, 6);

            switch (choice) {
                case 1:
                    System.out.print("\nEnter Title: ");
                    String title = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (book.getTitle().equalsIgnoreCase(title)) {
                            results.add(book);
                        }
                    }
                    break searchbook;
                case 2:
                    System.out.print("\nEnter Author: ");
                    String author = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        System.out.println("Auth: " + book.getAuthor());
                        if (!Objects.equals(book.getAuthor(),null)) {
                            if (book.getTitle().equalsIgnoreCase(author)) {
                                results.add(book);
                            }
                        }
                    }
                    break searchbook;
                case 3:
                    System.out.print("\nEnter ISBN: ");
                    String isbn = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (book.getISBN().equalsIgnoreCase(isbn)) {
                            results.add(book);
                        }
                    }
                    break;
                case 4:
                    System.out.print("\nEnter Genre: ");
                    String genre = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (book.getGenre().equalsIgnoreCase(genre)) {
                            results.add(book);
                        }
                    }
                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Invalid input, Select from the choices above");
            }
        }
        retrieveBooks(results);
    }

    static ArrayList<Book> searchBookTitle(String title) {
        ArrayList<Book> resultsTitle = new ArrayList<>();
        for (Book book: bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                resultsTitle.add(book);
            }
        }
        return resultsTitle;
    }


    // ==========================================
    static ArrayList<Book> getBookList() {
        return bookList;
    }

    static void retrieveBooks(ArrayList<Book> bookList) {
        int pageSize = 5;
        int currentPage = 1;
        int catalogPage = 0;
        int targetPage = pageSize - 1;

        while (true) {
            System.out.println("\n\n============================================= Book Catalog =============================================");
            System.out.println(String.format(
                    "%-45s || %-30s || %-15s",
                    "Title",
                    "Author",
                    "ISBN"
                )
            );
            System.out.println("========================================================================================================");

            if (targetPage >= bookList.size()) {
                targetPage = bookList.size() - 1;
            }

            if (catalogPage <= targetPage) {
                for (int i = catalogPage; i <= targetPage; i++) {
                    Book book = bookList.get(i);
                    if (book.getAuthor() == null) {
                        book.setAuthor("Not Indicated");
                    }
                    System.out.println(String.format(
                            "%-45s || %-30s || %-15s",
                            book.getTitle(),
                            book.getAuthor(),
                            book.getISBN()
                            )
                    );
                }
            } else {

                System.out.println("No books to display on this page.");
            }

            System.out.println("================================================= Page " + currentPage + " ===============================================\n" +
                    "[1] View next page\n" +
                    "[2] View previous page\n" +
                    "[3] Back to Main Menu");
            String inputStr = Main.inScanner.nextLine();
            switch (Main.inputCheck(inputStr, 3)) {
                case 0:
                    System.out.println("Invalid input, select from the choices");
                    break;
                case 1:
                    // Move to the next page
                    if (targetPage < bookList.size() - 1) {
                        catalogPage += pageSize;
                        targetPage += pageSize;
                        currentPage++;
                    } else {
                        System.out.println("\n\n===== No more pages to view. =====");
                    }
                    break;
                case 2:
                    if (catalogPage > 0) {
                        catalogPage -= pageSize;
                        targetPage = catalogPage + pageSize - 1;
                        currentPage--;
                    } else {
                        System.out.println("\n\n===== Already on the first page. =====");
                    }
                    break;
                case 3:
                    return;

            }
        }
    }



}
