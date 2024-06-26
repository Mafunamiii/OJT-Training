# Library Management System

This is a Java-based Library Management System that allows users to manage a catalog of books, including regular books, hardback books, e-books, and audiobooks.
## Java Documentation
- [Link to Javadoc](.javadocs/index.html)
## Technical Details
- Programming Language used: Java (JDK 17)
- Build: Maven

## Features

1. Browse Catalog: View all books in the library catalog.
2. Add Book: Add new books to the catalog with various details.
3. Remove Book: Remove books from the catalog by ID.
4. Search Book: Search for books by title, author, ISBN, genre, publisher, or language.
5. View Book Details: See detailed information about a specific book.

## Book Types

The system supports different types of books:

- Regular Books
- Hardback Books
- E-Books
- Audiobooks

Each book type has its own specific attributes in addition to common book information.

## Key Components

- `Main.java`: The entry point of the application, handling the main menu and user interaction.
- `ManageBook.java`: Contains the core functionality for managing books (adding, removing, searching, etc.).
- `Book.java`: contains the Book class and its book type subclasses
- `InputResult.java`: Handles input validation, it has three options where: '1' compares the input to be within the max choices, '2' checks if the input is an integer, '3' checks if the input is a double. 
- `loadBooks.java`: Handles loading books from a CSV files.

## How to Use

1. Run the `Main.java` file to start the application.
2. Use the main menu to navigate through different functions:
    - Enter '1' to browse the catalog
    - Enter '2' to add a new book
    - Enter '3' to remove a book
    - Enter '4' to search for a book
    - Enter '5' to view details of a specific book
    - Enter '6' to exit the program

3. Follow the prompts for each function to perform the desired action.

## Technical Details

- The system uses Java Streams for efficient data processing.
- Multithreading is implemented for displaying the book catalog, improving performance for large catalogs.
- Date parsing is handled for book publication dates.
- Input validation is implemented to ensure data integrity.

## Future Improvements

- Implement data persistence (database integration)

