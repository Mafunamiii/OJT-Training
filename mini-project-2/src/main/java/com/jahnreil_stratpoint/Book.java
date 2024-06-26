package com.jahnreil_stratpoint;

import lombok.*;

import java.time.LocalDate;

/**
 * Represents a book with various attributes such as ID, type, title, author, ISBN, etc.
 */


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookid;
    private String bookType;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String publisher;
    private LocalDate publicationDate;
    private String synopsis;
    private String language;

    /**
     * Constructs a Book object with basic information.
     *
     * @param bookid  The unique identifier of the book.
     * @param bookType The type of the book (e.g., regular, hardback, eBook, audioBook).
     * @param title   The title of the book.
     * @param isbn    The ISBN (International Standard Book Number) of the book.
     */
    public Book(int bookid, String bookType, String title, String isbn) {
        this.bookid = bookid;
        this.bookType = bookType;
        this.title = title;
        this.isbn = isbn;
    }

    /**
     * Constructs a Book object with author information.
     *
     * @param bookid  The unique identifier of the book.
     * @param bookType The type of the book (e.g., regular, hardback, eBook, audioBook).
     * @param title   The title of the book.
     * @param author  The author(s) of the book.
     * @param isbn    The ISBN (International Standard Book Number) of the book.
     */
    public Book(int bookid, String bookType, String title, String author, String isbn) {
        this.bookid = bookid;
        this.bookType = bookType;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Represents a hardback book, which extends the {@link Book} class.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    static class hardBack extends Book {
        private String coverType;
        private int pageCount;
        private double weightKG;

        /**
         * Constructs a hardback book with detailed information.
         *
         * @param bookid          The unique identifier of the book.
         * @param bookType        The type of the book (hardback).
         * @param title           The title of the book.
         * @param author          The author(s) of the book.
         * @param isbn            The ISBN (International Standard Book Number) of the book.
         * @param genre           The genre of the book.
         * @param publisher       The publisher of the book.
         * @param publicationDate The publication date of the book.
         * @param synopsis        A brief summary or synopsis of the book.
         * @param language        The language of the book.
         * @param coverType       The type of cover (e.g., hardcover, paperback).
         * @param pageCount       The number of pages in the hardback book.
         * @param weightKG        The weight of the book in kilograms.
         */
        public hardBack(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                        LocalDate publicationDate, String synopsis, String language,
                        String coverType, int pageCount, double weightKG) {
            super(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language);
            this.coverType = coverType;
            this.pageCount = pageCount;
            this.weightKG = weightKG;
        }

        /**
         * Constructs a hardback book with basic information.
         *
         * @param bookid    The unique identifier of the book.
         * @param bookType  The type of the book (hardback).
         * @param title     The title of the book.
         * @param isbn      The ISBN (International Standard Book Number) of the book.
         * @param pageCount The number of pages in the hardback book.
         * @param weightKG  The weight of the book in kilograms.
         */
        public hardBack(int bookid, String bookType, String title, String isbn, int pageCount, double weightKG) {
            super(bookid, bookType, title, isbn);
            this.pageCount = pageCount;
            this.weightKG = weightKG;
        }

        /**
         * Constructs a hardback book with basic information and default weight.
         *
         * @param bookid    The unique identifier of the book.
         * @param bookType  The type of the book (hardback).
         * @param title     The title of the book.
         * @param isbn      The ISBN (International Standard Book Number) of the book.
         * @param pageCount The number of pages in the hardback book.
         */
        public hardBack(int bookid, String bookType, String title, String isbn, int pageCount) {
            super(bookid, bookType, title, isbn);
            this.pageCount = pageCount;
        }

    }

    /**
     * Represents an eBook, which extends the {@link Book} class.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    static class eBook extends Book {
        private String fileFormat;
        private double fileSizeMB;


        /**
         * Constructs an eBook with detailed information.
         *
         * @param bookid          The unique identifier of the book.
         * @param bookType        The type of the book (eBook).
         * @param title           The title of the book.
         * @param author          The author(s) of the book.
         * @param isbn            The ISBN (International Standard Book Number) of the book.
         * @param genre           The genre of the book.
         * @param publisher       The publisher of the book.
         * @param publicationDate The publication date of the book.
         * @param synopsis        A brief summary or synopsis of the book.
         * @param language        The language of the book.
         * @param fileFormat      The file format of the eBook (e.g., PDF, EPUB).
         * @param fileSizeMB      The file size of the eBook in megabytes.
         */
        public eBook(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                     LocalDate publicationDate, String synopsis, String language,
                     String fileFormat, double fileSizeMB) {
            super(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language);
            this.fileFormat = fileFormat;
            this.fileSizeMB = fileSizeMB;
        }

        /**
         * Constructs an eBook with basic information.
         *
         * @param bookid    The unique identifier of the book.
         * @param bookType  The type of the book (eBook).
         * @param title     The title of the book.
         * @param isbn      The ISBN (International Standard Book Number) of the book.
         * @param fileFormat The file format of the eBook (e.g., PDF, EPUB).
         */
        public eBook(int bookid, String bookType, String title, String isbn, String fileFormat) {
            super(bookid, bookType, title, isbn);
            this.fileFormat = fileFormat;
        }

        /**
         * Constructs an eBook with basic information and default file size.
         *
         * @param bookid    The unique identifier of the book.
         * @param bookType  The type of the book (eBook).
         * @param title     The title of the book.
         * @param author    The author(s) of the book.
         * @param isbn      The ISBN (International Standard Book Number) of the book.
         * @param fileFormat The file format of the eBook (e.g., PDF, EPUB).
         */
        public eBook(int bookid, String bookType, String title, String author, String isbn, String fileFormat) {
            super(bookid, bookType, title, author, isbn);
            this.fileFormat = fileFormat;
        }

    }
    /**
     * Represents an audio book, which extends the {@link eBook} class.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = true)
    static class audioBook extends eBook {
        private String audioFormat;
        private String bitrate;

        /**
         * Constructs an audio book with detailed information.
         *
         * @param bookid          The unique identifier of the book.
         * @param bookType        The type of the book (audioBook).
         * @param title           The title of the book.
         * @param author          The author(s) of the book.
         * @param isbn            The ISBN (International Standard Book Number) of the book.
         * @param genre           The genre of the book.
         * @param publisher       The publisher of the book.
         * @param publicationDate The publication date of the book.
         * @param synopsis        A brief summary or synopsis of the book.
         * @param language        The language of the book.
         * @param fileFormat      The file format of the eBook (e.g., MP3, AAC).
         * @param fileSizeMB      The file size of the eBook in megabytes.
         * @param audioFormat     The audio format of the audio book (e.g., MP3, AAC).
         * @param bitrate         The bitrate of the audio book.
         */

        public audioBook(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                         LocalDate publicationDate, String synopsis, String language,
                         String fileFormat, double fileSizeMB,
                         String audioFormat, String bitrate) {
            super(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language, fileFormat, fileSizeMB);
            this.audioFormat = audioFormat;
            this.bitrate = bitrate;
        }

        /**
         * Constructs an audio book with basic information.
         *
         * @param bookid      The unique identifier of the book.
         * @param bookType    The type of the book (audioBook).
         * @param title       The title of the book.
         * @param isbn        The ISBN (International Standard Book Number) of the book.
         * @param fileFormat  The file format of the eBook (e.g., MP3, AAC).
         * @param audioFormat The audio format of the audio book (e.g., MP3, AAC).
         * @param bitrate     The bitrate of the audio book.
         */
        public audioBook(int bookid, String bookType, String title, String isbn, String fileFormat, String audioFormat, String bitrate) {
            super(bookid, bookType, title, isbn, fileFormat);
            this.audioFormat = audioFormat;
            this.bitrate = bitrate;
        }

        /**
         * Constructs an audio book with basic information and default bitrate.
         *
         * @param bookid      The unique identifier of the book.
         * @param bookType    The type of the book (audioBook).
         * @param title       The title of the book.
         * @param isbn        The ISBN (International Standard Book Number) of the book.
         * @param fileFormat  The file format of the eBook (e.g., MP3, AAC).
         * @param audioFormat The audio format of the audio book (e.g., MP3, AAC).
         */
        public audioBook(int bookid, String bookType, String title, String isbn, String fileFormat, String audioFormat) {
            super(bookid, bookType, title, isbn, fileFormat);
            this.audioFormat = audioFormat;
        }

    }
}
