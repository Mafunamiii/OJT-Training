package com.jahnreil_stratpoint;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class loadBooks {
    private ArrayList<Book> BookList;
    private ManageBook managebook;

    public loadBooks(ArrayList<Book> bookList, ManageBook managebooks) {
        this.BookList = bookList;
        this.managebook = managebooks;
    }

    public ArrayList<Book> loadFromCSV() {
        String initialDirectory = "src/main/java/com/jahnreil_stratpoint/dataCSV/";
        String[] filePaths = {
                "regularBookdata/bookNoAuthor.csv",
                "regularBookdata/bookRegular.csv",
                "hardBackBookdata/hardBackNoAuthor.csv",
                "hardBackBookdata/hardBackNoWeight.csv",
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
