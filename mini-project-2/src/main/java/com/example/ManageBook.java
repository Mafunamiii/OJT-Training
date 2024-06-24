package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
    // remove book by id
    static void removeBook(String isbn) {

    }

    // ==========================================
    // book search feature
    public void searchBook(ArrayList<Book> bookList) {

        final int searchTypeChoice;
        final String searchTerm;

        while (true) {
            System.out.print(
                    """
                    ============== Search by? ==============
                                [1] Title
                                [2] Author
                                [3] ISBN
                                [4] Genre
                                [5] Publisher
                                [6] Language
                                [7] Back to Main menu
                    ►""");
            String input = Main.inScanner.nextLine();
            searchTypeChoice = Main.inputCheck(input, 6);

            System.out.print("\nSearch: ");
            searchTerm = Main.inScanner.nextLine();

            if (searchTypeChoice == 7) {
                return;
            }
            /*
            switch (choice) {
                case 1:

                    System.out.print("\nEnter Title: ");
                    String title = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (book.getTitle().equalsIgnoreCase(title)) {
                            results.add(book);
                        }
                    }
                    searchTypeChoice = 1;
                    break searchbook;
                case 2:
                    System.out.print("\nEnter Author: ");
                    String author = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (!Objects.equals(book.getAuthor(),null)) { // author may not be present for some books
                            if (book.getAuthor().equalsIgnoreCase(author)) {
                                results.add(book);
                            }
                        }
                    }
                    break searchbook;
                case 3:
                    System.out.print("\nEnter ISBN: ");
                    String isbn = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (book.getISBN().equals(isbn)) {
                            results.add(book);
                        }
                    }
                    break searchbook;
                case 4:
                    System.out.print("\nEnter Genre: ");
                    String genre = Main.inScanner.nextLine();
                    for (Book book: bookList) {
                        if (!Objects.equals(book.getGenre(),null)) { // author may not be present for some books
                            if (book.getGenre().equalsIgnoreCase(genre)) {
                                results.add(book);
                            }
                        }
                    }
                    break searchbook;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Invalid input, Select from the choices above");
            }
        }*/
            List<Book> results = bookList.stream()
                    .filter(book -> matchSearch(book, searchTypeChoice, searchTerm))
                    .collect(Collectors.toList());
            retrieveBooks((ArrayList<Book>) results);
            break;
        }

    }
    static boolean matchSearch(Book book, int searchType, String searchTerm) {
        switch (searchType){
            case 1:
                return book.getTitle().equalsIgnoreCase(searchTerm);
            case 2:
                return book.getAuthor() != null && book.getAuthor().equalsIgnoreCase(searchTerm);
            case 3:
                return book.getISBN().equals(searchTerm);
            case 4:
                return book.getGenre() != null && book.getGenre().equalsIgnoreCase(searchTerm);
            case 5:
                return book.getPublisher() != null && book.getPublisher().equalsIgnoreCase(searchTerm);
            case 6:
                return book.getLanguage() != null && book.getLanguage().equalsIgnoreCase(searchTerm);
            default:
                throw new IllegalArgumentException("Error: Invalid Search, please select from the choices");
        }
    }

    // ==========================================
    // retrieve and display books

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
