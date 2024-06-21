package org.example;

import java.util.ArrayList;

public class loadBooks {
    private ArrayList<Book> BookList;
    private ManageBook managebook;

    public loadBooks(ArrayList<Book> bookList, ManageBook managebooks) {
        this.BookList = bookList;
        this.managebook = managebooks;
    }

    public ArrayList<Book> loadToList () {
        managebook.addBook("To Kill a Mockingbird", "978-0060935467");
        managebook.addBook("1984", "George Orwell", "978-0451524935");
        managebook.addBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        managebook.addBook("Pride and Prejudice", "Jane Austen", "978-1503290563");
        managebook.addBook("The Catcher in the Rye", "J.D. Salinger", "978-0316769488");
        managebook.addBook("The Hobbit", "978-0547928227");
        managebook.addBook("Moby Dick", "978-1503280786");
        managebook.addBook("War and Peace", "Leo Tolstoy", "978-1400079988");
        managebook.addBook("Crime and Punishment", "Fyodor Dostoevsky", "978-0486415871");
        managebook.addBook("The Odyssey", "Homer", "978-0140268867");
        managebook.addBook("Brave New World", "978-0060850524");
        managebook.addBook("The Lord of the Rings", "J.R.R. Tolkien", "978-0544003415");
        managebook.addBook("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427");
        managebook.addBook("The Chronicles of Narnia", "C.S. Lewis", "978-0066238500");
        managebook.addBook("Animal Farm", "978-0451526342");
        managebook.addBook("The Book Thief", "Markus Zusak", "978-0375842207");
        managebook.addBook("The Hunger Games", "Suzanne Collins", "978-0439023481");
        managebook.addBook("The Kite Runner", "978-1594631931");
        managebook.addBook("The Da Vinci Code", "Dan Brown", "978-0307474278");
        managebook.addBook("Inferno", "Dan Brown", "978-0385537858");

// Adding Hardbacks
        managebook.addHardBack(new Book("To Kill a Mockingbird", "978-0060935467"), 324);
        managebook.addHardBack(new Book("The Hobbit", "978-0547928227"), "Leather", 310, 1.5);
        managebook.addHardBack(new Book("Brave New World", "978-0060850524"), 268);
        managebook.addHardBack(new Book("Moby Dick", "978-1503280786"), "Hardcover", 635, 1.8);
        managebook.addHardBack(new Book("War and Peace", "978-1400079988"), "Cloth", 1225, 2.5);
        managebook.addHardBack(new Book("The Odyssey", "978-0140268867"), "Hardcover", 561, 1.7);
        managebook.addHardBack(new Book("The Great Gatsby", "978-0743273565"), "Leather", 180, 0.5);
        managebook.addHardBack(new Book("The Catcher in the Rye", "978-0316769488"), "Cloth", 214, 0.6);

// Adding EBooks
        managebook.addEBook(new Book("1984", "George Orwell", "978-0451524935"), "PDF", 1.5);
        managebook.addEBook(new Book("Pride and Prejudice", "Jane Austen", "978-1503290563"), "EPUB", 2.1);
        managebook.addEBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"), "MOBI", 1.2);
        managebook.addEBook(new Book("Moby Dick", "Herman Melville", "978-1503280786"), "PDF", 1.7);
        managebook.addEBook(new Book("War and Peace", "Leo Tolstoy", "978-1400079988"), "EPUB", 2.8);
        managebook.addEBook(new Book("Crime and Punishment", "Fyodor Dostoevsky", "978-0486415871"), "PDF", 1.6);
        managebook.addEBook(new Book("The Odyssey", "Homer", "978-0140268867"), "EPUB", 1.9);
        managebook.addEBook(new Book("Brave New World", "Aldous Huxley", "978-0060850524"), "PDF", 1.4);
        managebook.addEBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0544003415"), "MOBI", 3.5);
        managebook.addEBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427"), "EPUB", 2.3);
        managebook.addEBook(new Book("The Chronicles of Narnia", "C.S. Lewis", "978-0066238500"), "PDF", 1.8);
        managebook.addEBook(new Book("Animal Farm", "978-0451526342"), "MOBI", 1.2);
        managebook.addEBook(new Book("The Book Thief", "Markus Zusak", "978-0375842207"), "PDF", 1.7);
        managebook.addEBook(new Book("The Hunger Games", "Suzanne Collins", "978-0439023481"), "EPUB", 1.9);

// Adding Audiobooks
        managebook.addAudioBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"), "MP3", 100.0, "AAC", "128kbps");
        managebook.addAudioBook(new Book("Moby Dick", "Herman Melville", "978-1503280786"), "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427"), "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book("The Hunger Games", "Suzanne Collins", "978-0439023481"), "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book("The Kite Runner", "978-1594631931"), "MP3", "AAC", "96kbps");
        managebook.addAudioBook(new Book("The Da Vinci Code", "Dan Brown", "978-0307474278"), "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book("Inferno", "Dan Brown", "978-0385537858"), "MP3", "AAC", "192kbps");
        managebook.addAudioBook(new Book("Brave New World", "978-0060850524"), "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book("1984", "George Orwell", "978-0451524935"), "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book("The Chronicles of Narnia", "C.S. Lewis", "978-0066238500"), "MP3", "AAC", "96kbps");


        return BookList;
    };
}
