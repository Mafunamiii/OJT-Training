package com.jahnreil_stratpoint;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void testConstructorWithBasicInformation() {
        Book book = new Book(1, "regular", "Sample Book", "1234567890");

        assertEquals(1, book.getBookid());
        assertEquals("regular", book.getBookType());
        assertEquals("Sample Book", book.getTitle());
        assertEquals("1234567890", book.getISBN());
        assertNull(book.getAuthor());
        assertNull(book.getGenre());
        assertNull(book.getPublisher());
        assertNull(book.getPublicationDate());
        assertNull(book.getSynopsis());
        assertNull(book.getLanguage());
    }

    @Test
    void testConstructorWithAuthor() {
        Book book = new Book(2, "eBook", "Example eBook", "John Doe", "0987654321");

        assertEquals(2, book.getBookid());
        assertEquals("eBook", book.getBookType());
        assertEquals("Example eBook", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals("0987654321", book.getISBN());
        assertNull(book.getGenre());
        assertNull(book.getPublisher());
        assertNull(book.getPublicationDate());
        assertNull(book.getSynopsis());
        assertNull(book.getLanguage());
    }

    @Test
    void testConstructorWithDetailedInformation() {
        LocalDate publicationDate = LocalDate.of(2023, 5, 15);
        Book book = new Book(3, "audioBook", "Audiobook Example", "Jane Smith", "5678901234",
                "Fiction", "PublisherX", publicationDate, "Synopsis of the audiobook", "English");

        assertEquals(3, book.getBookid());
        assertEquals("audioBook", book.getBookType());
        assertEquals("Audiobook Example", book.getTitle());
        assertEquals("Jane Smith", book.getAuthor());
        assertEquals("5678901234", book.getISBN());
        assertEquals("Fiction", book.getGenre());
        assertEquals("PublisherX", book.getPublisher());
        assertEquals(publicationDate, book.getPublicationDate());
        assertEquals("Synopsis of the audiobook", book.getSynopsis());
        assertEquals("English", book.getLanguage());
    }

    @Test
    void testSettersAndGetters() {
        Book book = new Book(4, "regular", "Book with Setters", "5432109876");

        book.setAuthor("Mark Johnson");
        book.setGenre("Non-fiction");
        book.setPublisher("PublisherY");
        LocalDate publicationDate = LocalDate.of(2022, 8, 20);
        book.setPublicationDate(publicationDate);
        book.setSynopsis("Synopsis of the book");
        book.setLanguage("Spanish");

        assertEquals(4, book.getBookid());
        assertEquals("regular", book.getBookType());
        assertEquals("Book with Setters", book.getTitle());
        assertEquals("5432109876", book.getISBN());
        assertEquals("Mark Johnson", book.getAuthor());
        assertEquals("Non-fiction", book.getGenre());
        assertEquals("PublisherY", book.getPublisher());
        assertEquals(publicationDate, book.getPublicationDate());
        assertEquals("Synopsis of the book", book.getSynopsis());
        assertEquals("Spanish", book.getLanguage());
    }
}
