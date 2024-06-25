package com.jahnreil_stratpoint;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.concurrent.*;

public class ManageBook {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static InputResult inputcheck;
    public ManageBook (ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    // ==========================================
    // add books
    public void addBook (ArrayList<Book> bookList) {
        while (true) {
            System.out.println("""
            ======== Add Book ========
               [1] Add book entry 
               [2] Add Hardback book
               [3] Add E-Book
               [4] Add AudioBook
               [5] Back to main menu
        ►""");

            String input = Main.inScanner.nextLine();
            inputcheck = InputResult.inputCheck(input,5,1);

            if (inputcheck.isValid) {
                switch (inputcheck.valueInt) {
                    case 1:
                        addRegularBook();
                        break;
                    case 2:
                        addHardBackBook();
                        break;
                    case 3:
                        addEBookBook();
                        break;
                    case 4:
                        addAudioBook();
                        break;
                    case 5:
                        return;
                }

                break;
            } else {
                System.out.println("Select from the given choices");
                continue;
            }
        }



    }
    public void addRegularBook() {
        String title, author, isbn, genre, publisher, synopsis, language;
        LocalDate publicationdate;

        while (true) {
            System.out.println("""
                    ======== Add Book ========
                    (select which option is appropriate with your book information) 
                        [1] with Title and isbn.
                        [2] with Title, Author, and ISBN.
                        [3] with Complete information.
                        [4] Back to main menu
                    
                    [note: Complete information incl: Title, Author, ISBN, Genre, Publisher, PublicationDate, Synopsis, and Language]
                    
                    ►""");

            String input = Main.inScanner.nextLine();
            inputcheck = InputResult.inputCheck(input, 4,1);

            if (inputcheck.isValid) {
                switch (inputcheck.valueInt) {
                    case 1:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        addBook(bookList.get(bookList.size()-1).getBookid()+1,"Regular", title, isbn);
                        break;
                    case 2:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter author: ");
                        author = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        addBook(bookList.get(bookList.size()-1).getBookid()+1,"Regular", title, author, isbn);
                        break;
                    case 3:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter author: ");
                        author = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();
                        System.out.print("Enter genre: ");
                        genre = Main.inScanner.nextLine();
                        System.out.print("Enter publisher: ");
                        publisher = Main.inScanner.nextLine();
                        publicationdate = parsedate();
                        System.out.print("Enter synopsis: ");
                        synopsis = Main.inScanner.nextLine();
                        System.out.print("Enter language: ");
                        language = Main.inScanner.nextLine();

                        addBook(bookList.get(bookList.size()-1).getBookid()+1,
                                "Regular",
                                title,
                                author,
                                isbn,
                                genre,
                                publisher,
                                publicationdate,
                                synopsis,
                                language
                                );

                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please select from the choices");
                        continue;
                }

                break;
            }
        }
    }
    public void addHardBackBook() {
        String title, author, isbn, genre, publisher, synopsis, language, covertype;
        LocalDate publicationdate;
        int pagecount;
        double bookweight;

        Book currentbook;

        while (true) {
            System.out.println("""
                    ======== Add Book ========
                    (select which option is appropriate with your book information) 
                        [1] with title, ISBN, and number of pages.
                        [2] with title, ISBN, number of pages, and book weight.
                        [3] with title, ISBN, type of cover, number of pages, and book weight.
                        [4] with title, author, ISBN, type of cover, number of pages, and book weight.
                        [5] with Complete information.
                        [6] Back to main menu
                    
                    [note: Complete information incl: Title, Author, ISBN, Genre, Publisher, Publication Date, Synopsis, Language
                    type of cover, number of pages, and book weight]                    
                    ►""");

            String input = Main.inScanner.nextLine();
            inputcheck = InputResult.inputCheck(input, 4,1);

            if (inputcheck.isValid) {
                switch (inputcheck.valueInt) {
                    case 1:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        System.out.print("Enter pagecount:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        pagecount = inputcheck.valueInt;
                        currentbook = new Book(bookList.get(bookList.size()-1).getBookid()+1,
                                "HardBack",
                                title,
                                isbn);
                        addHardBack(currentbook, currentbook.getBookid(), "HardBack", pagecount);
                        break;
                    case 2:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        System.out.print("Enter pagecount:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        pagecount = inputcheck.valueInt;

                        System.out.print("Enter Book Weight[KG]:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        bookweight = inputcheck.valueDouble;
                        currentbook = new Book(bookList.get(bookList.size()-1).getBookid()+1,
                                "HardBack",
                                title,
                                isbn);
                        addHardBack(currentbook,
                                currentbook.getBookid(),
                                "HardBack",
                                pagecount,
                                bookweight);
                        break;

                    case 3:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        System.out.print("Enter Type of cover:");
                        covertype = Main.inScanner.nextLine();

                        System.out.print("Enter pagecount:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        pagecount = inputcheck.valueInt;

                        System.out.print("Enter Book Weight[KG]:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        bookweight = inputcheck.valueDouble;
                        currentbook = new Book(bookList.get(bookList.size()-1).getBookid()+1,
                                "HardBack",
                                title,
                                isbn);
                        addHardBack(currentbook,
                                currentbook.getBookid(),
                                "HardBack",
                                covertype,
                                pagecount,
                                bookweight);
                        break;
                    case 4:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter author: ");
                        author = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        System.out.print("Enter Type of cover:");
                        covertype = Main.inScanner.nextLine();

                        System.out.print("Enter pagecount:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        pagecount = inputcheck.valueInt;

                        System.out.print("Enter Book Weight[KG]:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        bookweight = inputcheck.valueDouble;
                        currentbook = new Book(bookList.get(bookList.size()-1).getBookid()+1,
                                "HardBack",
                                author,
                                title,
                                isbn);
                        addHardBack(currentbook,
                                currentbook.getBookid(),
                                "HardBack",
                                covertype,
                                pagecount,
                                bookweight);
                        break;
                    case 5:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter author: ");
                        author = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();
                        System.out.print("Enter genre: ");
                        genre = Main.inScanner.nextLine();
                        System.out.print("Enter publisher: ");
                        publisher = Main.inScanner.nextLine();
                        publicationdate = parsedate();
                        System.out.print("Enter synopsis: ");
                        synopsis = Main.inScanner.nextLine();
                        System.out.print("Enter language: ");
                        language = Main.inScanner.nextLine();

                        System.out.print("Enter Type of cover:");
                        covertype = Main.inScanner.nextLine();

                        System.out.print("Enter pagecount:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        pagecount = inputcheck.valueInt;

                        System.out.print("Enter Book Weight[KG]:");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        bookweight = inputcheck.valueDouble;

                        currentbook = new Book(
                                bookList.get(bookList.size()-1).getBookid()+1,
                                "Regular",
                                title,
                                author,
                                isbn,
                                genre,
                                publisher,
                                publicationdate,
                                synopsis,
                                language
                        );
                        addHardBack(currentbook,
                                currentbook.getBookid(),
                                "HardBack",
                                covertype,
                                pagecount,
                                bookweight);

                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Please select from the choices");
                        continue;
                }

                break;
            }
        }
    }
    public void addEBookBook() {
        String title, author, isbn, genre, publisher, synopsis, language, fileFormat;
        LocalDate publicationdate;
        double fileSizeMB;

        Book currentbook;

        while (true) {
            System.out.println("""
                    ======== Add Book ========
                    (select which option is appropriate with your book information) 
                        [1] with title, ISBN, and file format.
                        [2] with title, ISBN, file format, and file size;
                        [3] with Complete information.
                        [4] Back to main menu
                    
                    [note: Complete information incl: Title, Author, ISBN, Genre, Publisher, Publication Date, Synopsis, Language,
                    File Format, and File Size]                    
                    ►""");

            String input = Main.inScanner.nextLine();
            inputcheck = InputResult.inputCheck(input, 4,1);

            if (inputcheck.isValid) {
                switch (inputcheck.valueInt) {
                    case 1:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        System.out.print("Enter file format:");
                        fileFormat = Main.inScanner.nextLine();

                        currentbook = new Book(bookList.get(bookList.size()-1).getBookid()+1,
                                "EBook",
                                title,
                                isbn);
                        addEBook(currentbook, currentbook.getBookid(), "EBook", fileFormat);
                        break;
                    case 2:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();

                        System.out.print("Enter file format:");
                        fileFormat = Main.inScanner.nextLine();

                        System.out.print("Enter file size:");
                        input = Main.inScanner.nextLine();

                        inputcheck = InputResult.inputCheck(input,0,2);
                        fileSizeMB = inputcheck.valueDouble;

                        currentbook = new Book(bookList.get(bookList.size()-1).getBookid()+1,
                                "EBook",
                                title,
                                isbn);
                            addEBook(currentbook,
                                    currentbook.getBookid(),
                                    "EBook",
                                    fileFormat,
                                    fileSizeMB);
                        break;
                    case 3:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter author: ");
                        author = Main.inScanner.nextLine();
                        System.out.print("Enter isbn: ");
                        isbn = Main.inScanner.nextLine();
                        System.out.print("Enter genre: ");
                        genre = Main.inScanner.nextLine();
                        System.out.print("Enter publisher: ");
                        publisher = Main.inScanner.nextLine();
                        publicationdate = parsedate();
                        System.out.print("Enter synopsis: ");
                        synopsis = Main.inScanner.nextLine();
                        System.out.print("Enter language: ");
                        language = Main.inScanner.nextLine();

                        System.out.print("Enter file format:");
                        fileFormat = Main.inScanner.nextLine();

                        System.out.print("Enter file size:");
                        input = Main.inScanner.nextLine();

                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        fileSizeMB = inputcheck.valueDouble;

                        currentbook = new Book(
                                bookList.get(bookList.size()-1).getBookid()+1,
                                "EBook",
                                title,
                                author,
                                isbn,
                                genre,
                                publisher,
                                publicationdate,
                                synopsis,
                                language
                        );
                        addEBook(currentbook,
                                currentbook.getBookid(),
                                "EBook",
                                fileFormat,
                                fileSizeMB);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please select from the choices");
                        continue;
                }
                break;
            }
        }
    }
    public void addAudioBook() {
        String title, author, isbn, genre, publisher, synopsis, language, fileFormat, audioFormat, bitrate;
        LocalDate publicationDate;
        double fileSizeMB;

        Book currentBook;

        while (true) {
            System.out.println("""
                ======== Add Audiobook ========
                (select which option is appropriate with your book information) 
                    [1] with title, ISBN, file format, and audio format.
                    [2] with title, ISBN, file format, audio format, and bitrate.
                    [3] with Complete information.
                    [4] Back to main menu
                
                [note: Complete information incl: Title, Author, ISBN, Genre, Publisher, Publication Date, Synopsis, Language,
                File Format, File Size, Audio Format, and Bitrate]                    
                ►""");

            String input = Main.inScanner.nextLine();
            inputcheck = InputResult.inputCheck(input, 4, 1);

            if (inputcheck.isValid) {
                switch (inputcheck.valueInt) {
                    case 1:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        isbn = Main.inScanner.nextLine();
                        System.out.print("Enter file format: ");
                        fileFormat = Main.inScanner.nextLine();
                        System.out.print("Enter audio format: ");
                        audioFormat = Main.inScanner.nextLine();

                        currentBook = new Book(bookList.get(bookList.size() - 1).getBookid() + 1,
                                "AudioBook",
                                title,
                                isbn);
                        addAudioBook(currentBook,
                                currentBook.getBookid(),
                                "AudioBook",
                                fileFormat,
                                audioFormat);
                        break;
                    case 2:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        isbn = Main.inScanner.nextLine();
                        System.out.print("Enter file format: ");
                        fileFormat = Main.inScanner.nextLine();
                        System.out.print("Enter audio format: ");
                        audioFormat = Main.inScanner.nextLine();
                        System.out.print("Enter bitrate: ");
                        bitrate = Main.inScanner.nextLine();

                        currentBook = new Book(bookList.get(bookList.size() - 1).getBookid() + 1,
                                "AudioBook",
                                title,
                                isbn);
                        addAudioBook(currentBook,
                                currentBook.getBookid(),
                                "AudioBook",
                                fileFormat,
                                audioFormat,
                                bitrate);
                        break;
                    case 3:
                        System.out.print("Enter Title: ");
                        title = Main.inScanner.nextLine();
                        System.out.print("Enter author: ");
                        author = Main.inScanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        isbn = Main.inScanner.nextLine();
                        System.out.print("Enter genre: ");
                        genre = Main.inScanner.nextLine();
                        System.out.print("Enter publisher: ");
                        publisher = Main.inScanner.nextLine();
                        publicationDate = parsedate();
                        System.out.print("Enter synopsis: ");
                        synopsis = Main.inScanner.nextLine();
                        System.out.print("Enter language: ");
                        language = Main.inScanner.nextLine();
                        System.out.print("Enter file format: ");
                        fileFormat = Main.inScanner.nextLine();
                        System.out.print("Enter file size: ");
                        input = Main.inScanner.nextLine();
                        inputcheck = InputResult.inputCheck(input, 0, 2);
                        fileSizeMB = inputcheck.valueDouble;
                        System.out.print("Enter audio format: ");
                        audioFormat = Main.inScanner.nextLine();
                        System.out.print("Enter bitrate: ");
                        bitrate = Main.inScanner.nextLine();

                        currentBook = new Book(bookList.get(bookList.size() - 1).getBookid() + 1,
                                "Regular",
                                title,
                                author,
                                isbn,
                                genre,
                                publisher,
                                publicationDate,
                                synopsis,
                                language);
                        addAudioBook(currentBook,
                                currentBook.getBookid(),
                                "AudioBook",
                                fileFormat,
                                fileSizeMB,
                                audioFormat,
                                bitrate);
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Please select from the choices");
                        continue;
                }
                break;
            }
        }


    }
    // add regular book variants
    public void addBook(int bookid, String bookType, String title, String isbn) {
        bookList.add(new Book(bookid, bookType, title, isbn));
    }
    public void addBook(int bookid, String bookType, String title, String author,
                        String isbn) {
        bookList.add(new Book(bookid, bookType, title, author, isbn));
    }
    public void addBook(int bookid, String bookType, String title,
                        String author, String isbn,String genre, String publisher,
                        LocalDate publicationDate, String synopsis, String language) {
        bookList.add(new Book(bookid, bookType, title, author, isbn, genre, publisher, publicationDate, synopsis, language));
    }
    // add hardbook variants
    public void addHardBack(Book book,int bookid, String bookType,  int pagecount) {
        bookList.add(new Book.hardBack(
                bookid,
                bookType,
                book.getTitle(),
                book.getISBN(),
                pagecount
        ));
    }
    public void addHardBack(Book book,int bookid, String bookType,  int pagecount,
                            double weight) {
        bookList.add(new Book.hardBack(
                bookid,
                bookType,
                book.getTitle(),
                book.getISBN(),
                pagecount,
                weight
        ));
    }
    public void addHardBack(Book book, int bookid, String bookType, String coverType,
                            int pageCount, double weightKG) {
        bookList.add(new Book.hardBack(
                bookid,
                bookType,
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
    // add ebook variants
    public void addEBook(Book book, int bookid, String bookType, String fileFormat, double fileSize) {
        bookList.add(new Book.eBook(
                bookid,
                bookType,
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
    public void addEBook( Book book, int bookid, String bookType, String fileFormat) {
        bookList.add(new Book.eBook(
                bookid,
                bookType,
                book.getTitle(),
                book.getISBN(),
                fileFormat
        ));
    }

    // add audiobook variants
    public void addAudioBook(Book book, int bookid, String bookType, String fileFormat,
                             double fileSize, String audioFormat, String bitrate) {
        bookList.add(new Book.audioBook(
                bookid,
                bookType,
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
    public void addAudioBook(Book book, int bookid, String bookType, String fileFormat,
                             String audioFormat, String bitrate) {
        bookList.add(new Book.audioBook(
                bookid,
                bookType,
                book.getTitle(),
                book.getISBN(),
                fileFormat,
                audioFormat,
                bitrate
        ));
    }
    static void addAudioBook(Book book, int bookid, String bookType, String fileFormat,
                             String audioFormat) {
        bookList.add(new Book.audioBook(
                bookid,
                bookType,
                book.getTitle(),
                book.getISBN(),
                fileFormat,
                audioFormat
        ));
    }
    // ==========================================
    // find book by ID
    public Optional<Book> findBook (ArrayList<Book> bookList, int id) {

        Optional<Book> FoundBook = bookList.stream()
                .filter(book -> book.getBookid() == id)
                .findFirst();

        return FoundBook;
    }

    // ==========================================
    // Remove book by ID
    public void removeBookById(ArrayList<Book> bookList) {

        while(true) {
            System.out.print("\nRemove book [enter book id]: ");
            String input = Main.inScanner.nextLine();

            InputResult inputcheck = InputResult.inputCheck(input, bookList.size(),1);
            int id;
            if (inputcheck.isValid) {
                id = inputcheck.valueInt;
            } else {
                continue;
            }

            try {
                if (id < bookList.size()) {
                    System.out.println("Removing " +
                            bookList.get(findBook(bookList,id-1).get().getBookid()).getTitle()
                            + " (" +
                            bookList.get(findBook(bookList,id-1).get().getBookid()).getBookType()
                            + ")");
                    removeBook(id);
                    break;
                } else {
                    throw new IllegalArgumentException("Book ID not found");
                }
            } catch(Exception e) {
                System.out.println("Book ID was not found, must be an existing book to continue");
                continue;
            }

        }
            System.out.print("Book removal successful");
            retrieveBooks(bookList);
    }
    static void removeBook(int bookid) {
        bookList.removeIf(book -> book.getBookid() == bookid);
    }

    // ==========================================
    // book search feature
    public void searchBook(ArrayList<Book> bookList) {

        int searchTypeChoice;
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
            InputResult inputcheck = InputResult.inputCheck(input, 7,1);

            if (inputcheck.isValid) {
                searchTypeChoice = inputcheck.valueInt;

                if (searchTypeChoice == 7) {
                    return;
                }
                System.out.print("\nSearch: ");
                searchTerm = Main.inScanner.nextLine();

                List<Book> results = bookList.stream()
                        .filter(book -> matchSearch(book, searchTypeChoice, searchTerm))
                        .collect(Collectors.toList());
                retrieveBooks((ArrayList<Book>) results);
                break;
            } else {
                System.out.println("Select from the given choices");
            }
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
    public static void retrieveBooks(ArrayList<Book> bookList) {
        int pageSize = 5;
        int currentPage = 1;
        int catalogPage = 0;
        int targetPage = pageSize - 1;

        ExecutorService executor = Executors.newFixedThreadPool(2); // Adjust number of threads as needed

        try {
            while (true) {
                System.out.println("\n\n============================================= Book Catalog =============================================");
                System.out.println(String.format(
                                "%5s || %13s || %-45s || %-30s || %-15s",
                                "id",
                                "Book Type",
                                "Title",
                                "Author",
                                "ISBN"
                        )
                );
                System.out.println("========================================================================================================");

                if (targetPage >= bookList.size()) {
                    targetPage = bookList.size() - 1;
                }

                List<Future<Void>> futures = new ArrayList<>();
                for (int i = catalogPage; i <= targetPage; i++) {
                    final int idx = i;
                    futures.add(executor.submit(() -> {
                        Book book = bookList.get(idx);
                        if (book.getAuthor() == null) {
                            book.setAuthor("Not Indicated");
                        }
                        System.out.println(String.format(
                                        "%5s || %13s || %-45s || %-30s || %-15s",
                                        book.getBookid(),
                                        book.getBookType(),
                                        book.getTitle(),
                                        book.getAuthor(),
                                        book.getISBN()
                                )
                        );
                        return null;
                    }));
                }

                // Wait for all tasks to complete
                for (Future<Void> future : futures) {
                    try {
                        future.get(); // Wait for each task to complete
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("================================================= Page " + currentPage + " ===============================================\n" +
                        "[1] View next page\n" +
                        "[2] View previous page\n" +
                        "[3] Back to Main Menu");
                String inputStr = Main.inScanner.nextLine();
                InputResult inputcheck = InputResult.inputCheck(inputStr, 3, 1);
                if (inputcheck.isValid) {
                    switch (inputcheck.valueInt) {
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
        } finally {
            executor.shutdown();
        }
    }

    // ==========================================
    // date parser
    static LocalDate parsedate() {
        LocalDate result;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.print("\nEnter Publication Date:");

            String input = Main.inScanner.nextLine();

            try {
                result = LocalDate.parse(input, formatter);

                break;
            } catch (DateTimeParseException e) {
                System.out.println("""
                        Error parsing publication date, use format 'yyyy-mm-dd
                        ex. 2024-06-25
                        """);
            }
        }
        return result;
    }

}
