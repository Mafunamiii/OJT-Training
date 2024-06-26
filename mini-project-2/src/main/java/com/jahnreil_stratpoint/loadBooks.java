package com.jahnreil_stratpoint;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Utility class to load book data from CSV and JSON files into an ArrayList of books using a specified management class.
 */
public class loadBooks {
    private ArrayList<Book> BookList;
    private ManageBook managebook;

    /**
     * Constructor for the loadBooks class.
     *
     * @param bookList     The ArrayList where books will be loaded.
     * @param managebooks  The management class used to add books to the list.
     */
    public loadBooks(ArrayList<Book> bookList, ManageBook managebooks) {
        this.BookList = bookList;
        this.managebook = managebooks;
    }

    /**
     * Loads book data from CSV files located in predefined directories into the BookList ArrayList.
     *
     * @return The ArrayList of books after loading from CSV files.
     */
    public ArrayList<Book> loadFromCSV() {
        String initialDirectory = "src/main/java/com/jahnreil_stratpoint/dataCSV/";
        String[] filePaths = {
                "regularBookdata/bookNoAuthor.csv",
                "regularBookdata/bookRegular.csv",
                "hardBackBookdata/hardBackNoAuthor.csv",
                "eBookdata/eBook.csv",
                "eBookdata/eBookNoAuthor.csv",
                "audioBookdata/audioBook.csv",
                "audioBookdata/audioBookNoBitrate.csv"
        };

        for (String relativePath : filePaths) {
            String filePath = initialDirectory + relativePath;
            parseCSV(filePath);
        }

        return BookList;
    }

    /**
     * Parses a CSV file containing book data and adds them to the BookList ArrayList.
     *
     * @param filePath The path to the CSV file to parse.
     */
    private void parseCSV(String filePath) {
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) return;

            String[] headers = header.split(csvSplitBy);
            int headerLength = headers.length;

            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(csvSplitBy);
                switch (headerLength) {
                    case 4:
                        if (headers[2].equals("author")) {
                            managebook.addBook(BookList.size() + 1, bookData[0], bookData[1], bookData[2], bookData[3]);
                        } else {
                            managebook.addBook(BookList.size() + 1, bookData[0], bookData[1], bookData[2]);
                        }
                        break;
                    case 5:
                        if (headers[3].equals("pagecount")) {
                            managebook.addHardBack(new Book(BookList.size() + 1, bookData[0], bookData[1], bookData[2]),
                                    BookList.size() + 1, bookData[0], Integer.parseInt(bookData[3]));
                        } else {
                            managebook.addEBook(new Book(BookList.size() + 1, bookData[0], bookData[1], bookData[2]),
                                    BookList.size() + 1, bookData[0], bookData[3]);
                        }
                        break;
                    case 6:
                        if (headers[4].equals("bookweight")) {
                            managebook.addHardBack(new Book(BookList.size() + 1, bookData[0], bookData[1], bookData[2]),
                                    BookList.size() + 1, bookData[0], bookData[3], Integer.parseInt(bookData[4]), Double.parseDouble(bookData[5]));
                        } else {
                            managebook.addEBook(new Book(BookList.size() + 1, bookData[0], bookData[1], bookData[2]),
                                    BookList.size() + 1, bookData[0], bookData[4], Double.parseDouble(bookData[5]));
                        }
                        break;
                    case 7:
                        managebook.addAudioBook(new Book(BookList.size() + 1, bookData[0], bookData[1], bookData[2]),
                                BookList.size() + 1, bookData[0], bookData[3], bookData[4], bookData[5]);
                        break;
                    case 8:
                        managebook.addAudioBook(new Book(BookList.size() + 1, bookData[0], bookData[1], bookData[2]),
                                BookList.size() + 1, bookData[0], bookData[3], Double.parseDouble(bookData[4]), bookData[5], bookData[6]);
                        break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
