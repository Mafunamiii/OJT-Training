package com.jahnreil_stratpoint;

import java.time.LocalDate;

/**
 * Represents a book with various attributes such as ID, type, title, author, ISBN, etc.
 */
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
     * Constructs a Book object with detailed information.
     *
     * @param bookid          The unique identifier of the book.
     * @param bookType        The type of the book (e.g., regular, hardback, eBook, audioBook).
     * @param title           The title of the book.
     * @param author          The author(s) of the book.
     * @param isbn            The ISBN (International Standard Book Number) of the book.
     * @param genre           The genre of the book.
     * @param publisher       The publisher of the book.
     * @param publicationDate The publication date of the book.
     * @param synopsis        A brief summary or synopsis of the book.
     * @param language        The language of the book.
     */
    public Book(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                LocalDate publicationDate, String synopsis, String language) {
        this.bookid = bookid;
        this.bookType = bookType;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.synopsis = synopsis;
        this.language = language;
    }

    /**
     * Gets the unique identifier of the book.
     *
     * @return The unique identifier of the book.
     */
    public int getBookid() {
        return bookid;
    }

    /**
     * Sets the unique identifier of the book.
     *
     * @param bookid The unique identifier of the book.
     */
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    /**
     * Gets the type of the book.
     *
     * @return The type of the book.
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * Sets the type of the book.
     *
     * @param bookType The type of the book.
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the author(s) of the book.
     *
     * @return The author(s) of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author(s) of the book.
     *
     * @param author The author(s) of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getISBN() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn The ISBN of the book.
     */
    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the genre of the book.
     *
     * @return The genre of the book.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the book.
     *
     * @param genre The genre of the book.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the publisher of the book.
     *
     * @return The publisher of the book.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book.
     *
     * @param publisher The publisher of the book.
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the publication date of the book.
     *
     * @return The publication date of the book.
     */
    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    /**
     * Sets the publication date of the book.
     *
     * @param publicationDate The publication date of the book.
     */
    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * Gets the synopsis of the book.
     *
     * @return The synopsis of the book.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Sets the synopsis of the book.
     *
     * @param synopsis The synopsis of the book.
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Gets the language of the book.
     *
     * @return The language of the book.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the language of the book.
     *
     * @param language The language of the book.
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Represents a hardback book, which extends the {@link Book} class.
     */
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

        /**
         * Gets the cover type of the hardback book.
         *
         * @return The cover type of the hardback book.
         */
        public String getCoverType() {
            return coverType;
        }

        /**
         * Sets the cover type of the hardback book.
         *
         * @param coverType The cover type of the hardback book.
         */
        public void setCoverType(String coverType) {
            this.coverType = coverType;
        }

        /**
         * Gets the page count of the hardback book.
         *
         * @return The page count of the hardback book.
         */
        public int getPageCount() {
            return pageCount;
        }

        /**
         * Sets the page count of the hardback book.
         *
         * @param pageCount The page count of the hardback book.
         */
        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        /**
         * Gets the weight of the hardback book.
         *
         * @return The weight of the hardback book in kilograms.
         */
        public String getWeightKG() {
            return weightKG + "kg";
        }

        /**
         * Sets the weight of the hardback book.
         *
         * @param weightKG The weight of the hardback book in kilograms.
         */
        public void setWeightKG(double weightKG) {
            this.weightKG = weightKG;
        }
    }

    /**
     * Represents an eBook, which extends the {@link Book} class.
     */
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

        /**
         * Gets the file format of the eBook.
         *
         * @return The file format of the eBook.
         */
        public String getFileFormat() {
            return fileFormat;
        }

        /**
         * Sets the file format of the eBook.
         *
         * @param fileFormat The file format of the eBook.
         */
        public void setFileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
        }

        /**
         * Gets the file size of the eBook.
         *
         * @return The file size of the eBook in megabytes.
         */
        public String getFileSizeMB() {
            return fileSizeMB + " MB";
        }

        /**
         * Sets the file size of the eBook.
         *
         * @param fileSizeMB The file size of the eBook in megabytes.
         */
        public void setFileSizeMB(double fileSizeMB) {
            this.fileSizeMB = fileSizeMB;
        }
    }
    /**
     * Represents an audio book, which extends the {@link eBook} class.
     */

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
         * @param bookid     The unique identifier of the book.
         * @param bookType   The type of the book (audioBook).
         * @param title      The title of the book.
         * @param isbn       The ISBN (International Standard Book Number) of the book.
         * @param fileFormat The file format of the eBook (e.g., MP3, AAC).
         * @param audioFormat The audio format of the audio book (e.g., MP3, AAC).
         * @param bitrate    The bitrate of the audio book.
         */
        public audioBook(int bookid, String bookType, String title, String isbn, String fileFormat, String audioFormat, String bitrate) {
            super(bookid, bookType, title, isbn, fileFormat);
            this.audioFormat = audioFormat;
            this.bitrate = bitrate;
        }
        /**
         * Constructs an audio book with basic information and default bitrate.
         *
         * @param bookid     The unique identifier of the book.
         * @param bookType   The type of the book (audioBook).
         * @param title      The title of the book.
         * @param isbn       The ISBN (International Standard Book Number) of the book.
         * @param fileFormat The file format of the eBook (e.g., MP3, AAC).
         * @param audioFormat The audio format of the audio book (e.g., MP3, AAC).
         */
        public audioBook(int bookid, String bookType, String title, String isbn, String fileFormat, String audioFormat) {
            super(bookid, bookType, title, isbn, fileFormat);
            this.audioFormat = audioFormat;
        }
        /**
         * Gets the bitrate of the audio book.
         *
         * @return The bitrate of the audio book.
         */
        // Getters and setters
        public String getBitrate() {
            return bitrate;
        }
        /**
         * Sets the bitrate of the audio book.
         *
         * @param bitrate The bitrate of the audio book.
         */
        public void setBitrate(String bitrate) {
            this.bitrate = bitrate;
        }
        /**
         * Gets the audio format of the audio book.
         *
         * @return The audio format of the audio book.
         */
        public String getAudioFormat() {
            return audioFormat;
        }
        /**
         * Sets the audio format of the audio book.
         *
         * @param audioFormat The audio format of the audio book.
         */
        public void setAudioFormat(String audioFormat) {
            this.audioFormat = audioFormat;
        }
    }
}
