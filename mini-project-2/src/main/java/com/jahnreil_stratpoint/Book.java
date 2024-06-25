package com.jahnreil_stratpoint;

import java.time.LocalDate;

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

    public Book(int bookid, String bookType, String title, String isbn) {
        this.bookid = bookid;
        this.bookType = bookType;
        this.title = title;
        this.isbn = isbn;
    }

    public Book(int bookid, String bookType, String title, String author, String isbn) {
        this.bookid = bookid;
        this.bookType = bookType;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

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

    // Getters and setters
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return isbn;
    }

    public void setISBN(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    static class hardBack extends Book {
        private String coverType;
        private int pageCount;
        private double weightKG;

        public hardBack(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                        LocalDate publicationDate, String synopsis, String language,
                        String coverType, int pageCount, double weightKG) {
            super(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language);
            this.coverType = coverType;
            this.pageCount = pageCount;
            this.weightKG = weightKG;
        }

        public hardBack(int bookid, String bookType, String title, String isbn, int pageCount, double weightKG) {
            super(bookid, bookType, title, isbn);
            this.pageCount = pageCount;
            this.weightKG = weightKG;
        }

        public hardBack(int bookid, String bookType, String title, String isbn, int pageCount) {
            super(bookid, bookType, title, isbn);
            this.pageCount = pageCount;
        }

        // Getters and setters
        public String getCoverType() {
            return coverType;
        }

        public void setCoverType(String coverType) {
            this.coverType = coverType;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public String getWeightKG() {
            return weightKG + "kg";
        }

        public void setWeightKG(double weightKG) {
            this.weightKG = weightKG;
        }
    }

    static class eBook extends Book {
        private String fileFormat;
        private double fileSizeMB;

        public eBook(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                     LocalDate publicationDate, String synopsis, String language,
                     String fileFormat, double fileSizeMB) {
            super(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language);
            this.fileFormat = fileFormat;
            this.fileSizeMB = fileSizeMB;
        }

        public eBook(int bookid, String bookType, String title, String isbn, String fileFormat) {
            super(bookid, bookType, title, isbn);
            this.fileFormat = fileFormat;
        }

        // Getters and setters
        public String getFileFormat() {
            return fileFormat;
        }

        public void setFileFormat(String fileFormat) {
            this.fileFormat = fileFormat;
        }

        public String getFileSizeMB() {
            return fileSizeMB + " MB";
        }

        public void setFileSizeMB(double fileSizeMB) {
            this.fileSizeMB = fileSizeMB;
        }
    }

    static class audioBook extends eBook {
        private String audioFormat;
        private String bitrate;

        public audioBook(int bookid, String bookType, String title, String author, String isbn, String genre, String publisher,
                         LocalDate publicationDate, String synopsis, String language,
                         String fileFormat, double fileSizeMB,
                         String audioFormat, String bitrate) {
            super(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language, fileFormat, fileSizeMB);
            this.audioFormat = audioFormat;
            this.bitrate = bitrate;
        }

        public audioBook(int bookid, String bookType, String title, String isbn, String fileFormat, String audioFormat, String bitrate) {
            super(bookid, bookType, title, isbn, fileFormat);
            this.audioFormat = audioFormat;
            this.bitrate = bitrate;
        }

        public audioBook(int bookid, String bookType, String title, String isbn, String fileFormat, String audioFormat) {
            super(bookid, bookType, title, isbn, fileFormat);
            this.audioFormat = audioFormat;
        }

        // Getters and setters
        public String getBitrate() {
            return bitrate;
        }

        public void setBitrate(String bitrate) {
            this.bitrate = bitrate;
        }

        public String getAudioFormat() {
            return audioFormat;
        }

        public void setAudioFormat(String audioFormat) {
            this.audioFormat = audioFormat;
        }
    }
}
