package org.example;

import java.util.ArrayList;

public class ManageBook {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    public ManageBook (ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

   public void addBook(String title, String isbn) {
        bookList.add(new Book(title,isbn));
    }

    public void addHardBack(Book book, int pagecount) {
        bookList.add(new Book.hardBack(book.getTitle(),book.getISBN(),pagecount));
    }

    static void addHardBack(Book book, String coverType, int pageCount, double weightKG) {

    }

    static void addEBook(Book book, String fileFormat, double fileSize ) {

    }

    static void addEBook(Book book, String fileFormat) {

    }

    static void addAudioBook(Book book, String fileFormat, double fileSize, String audioFormat, String bitrate) {

    }

    static void addAudioBook(Book book, String fileFormat, String audioFormat, String bitrate) {

    }

    static void addAudioBook(Book book, String fileFormat, String audioFormat) {

    }

    // ==========================================

    static void removeBook(String isbn) {

    }

    // ==========================================

    static void searchBook() {

    }

    // ==========================================
    static ArrayList<Book> getBookList() {
        return bookList;
    }

    static void retrieveBooks() {
        int pageSize = 5;
        int currentPage = 1;
        int catalogPage = 0;
        int targetPage = pageSize - 1;

        while (true) {
            System.out.println("\n\n========= Book Catalog =========\n" +
                    "Title            || Author/s           || ISBN                      ");

            if (targetPage >= bookList.size()) {
                targetPage = bookList.size() - 1;
            }

            if (catalogPage <= targetPage) {
                for (int i = catalogPage; i <= targetPage; i++) {
                    Book book = bookList.get(i);
                    if (book.getAuthor() == null) {
                        book.setAuthor("Not Indicated");
                    }
                    System.out.println(book.getTitle() + " || " + book.getAuthor() + "     ||    " + book.getISBN());
                }
            } else {

                System.out.println("No books to display on this page.");
            }

            System.out.println("==================== Page " + currentPage + " =====================\n" +
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
