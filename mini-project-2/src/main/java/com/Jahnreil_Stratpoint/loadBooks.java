package com.Jahnreil_Stratpoint;

import java.util.ArrayList;

public class loadBooks {
    private ArrayList<Book> BookList;
    private ManageBook managebook;

    public loadBooks(ArrayList<Book> bookList, ManageBook managebooks) {
        this.BookList = bookList;
        this.managebook = managebooks;
    }

    public ArrayList<Book> loadfromCSV () {


        return BookList;
    }

    public ArrayList<Book> loadToList () {
        int i = 1;
        managebook.addBook(i++, "regular", "Inferno", "Dan Brown", "978-0385537858");
        managebook.addBook(i++, "regular", "To Kill a Mockingbird", "978-0060935467");
        managebook.addBook(i++, "regular", "1984", "George Orwell", "978-0451524935");
        managebook.addBook(i++, "regular", "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        managebook.addBook(i++, "regular", "Pride and Prejudice", "Jane Austen", "978-1503290563");
        managebook.addBook(i++, "regular", "The Catcher in the Rye", "J.D. Salinger", "978-0316769488");
        managebook.addBook(i++, "regular", "The Hobbit", "978-0547928227");
        managebook.addBook(i++, "regular", "Moby Dick", "978-1503280786");
        managebook.addBook(i++, "regular", "War and Peace", "Leo Tolstoy", "978-1400079988");
        managebook.addBook(i++, "regular", "Crime and Punishment", "Fyodor Dostoevsky", "978-0486415871");
        managebook.addBook(i++, "regular", "The Odyssey", "Homer", "978-0140268867");
        managebook.addBook(i++, "regular", "Brave New World", "978-0060850524");
        managebook.addBook(i++, "regular", "The Lord of the Rings", "J.R.R. Tolkien", "978-0544003415");
        managebook.addBook(i++, "regular", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427");
        managebook.addBook(i++, "regular", "The Chronicles of Narnia", "C.S. Lewis", "978-0066238500");
        managebook.addBook(i++, "regular", "Animal Farm", "978-0451526342");
        managebook.addBook(i++, "regular", "The Book Thief", "Markus Zusak", "978-0375842207");
        managebook.addBook(i++, "regular", "The Hunger Games", "Suzanne Collins", "978-0439023481");
        managebook.addBook(i++, "regular", "The Kite Runner", "978-1594631931");
        managebook.addBook(i++, "regular", "The Da Vinci Code", "Dan Brown", "978-0307474278");

// Adding Hardbacks
        managebook.addHardBack(new Book(i++,"Hardback", "To Kill a Mockingbird", "978-0060935467"),i,"Hardback", 384);
        managebook.addHardBack(new Book(i++, "Hardback","The Hobbit", "978-0547928227"),i,"Hardback", "Leather", 310, 1.5);
        managebook.addHardBack(new Book(i++, "hardBack", "Brave New World", "978-0060850524"),i,"Hardback",268);

        managebook.addHardBack(new Book(i++, "Hardback", "Moby Dick", "978-1503280786"), i, "Hardback", "Hardcover", 635, 1.8);
        managebook.addHardBack(new Book(i++, "Hardback", "War and Peace", "978-1400079988"), i, "Hardback", "Cloth", 1225, 2.5);
        managebook.addHardBack(new Book(i++, "Hardback", "The Odyssey", "978-0140268867"), i, "Hardback", "Hardcover", 561, 1.7);
        managebook.addHardBack(new Book(i++, "Hardback", "The Great Gatsby", "978-0743273565"), i, "Hardback", "Leather", 180, 0.5);
        managebook.addHardBack(new Book(i++, "Hardback", "The Catcher in the Rye", "978-0316769488"), i, "Hardback", "Cloth", 214, 0.6);

// Adding EBooks
        managebook.addEBook(new Book(i++, "eBook", "1984", "George Orwell", "978-0451524935")                       , i, "eBook", "PDF", 1.5);
        managebook.addEBook(new Book(i++, "eBook", "Pride and Prejudice", "Jane Austen", "978-1503290563")          , i, "eBook", "EPUB", 2.1);
        managebook.addEBook(new Book(i++, "eBook", "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565")     , i, "eBook", "MOBI", 1.2);
        managebook.addEBook(new Book(i++, "eBook", "Moby Dick", "Herman Melville", "978-1503280786")                , i, "eBook", "PDF", 1.7);
        managebook.addEBook(new Book(i++, "eBook", "War and Peace", "Leo Tolstoy", "978-1400079988")                , i, "eBook", "EPUB", 2.8);
        managebook.addEBook(new Book(i++, "eBook", "Crime and Punishment", "Fyodor Dostoevsky", "978-0486415871")   , i, "eBook", "PDF", 1.6);
        managebook.addEBook(new Book(i++, "eBook", "The Odyssey", "Homer", "978-0140268867")                        , i, "eBook", "EPUB", 1.9);
        managebook.addEBook(new Book(i++, "eBook", "Brave New World", "Aldous Huxley", "978-0060850524")            , i, "eBook", "PDF", 1.4);
        managebook.addEBook(new Book(i++, "eBook", "The Lord of the Rings", "J.R.R. Tolkien", "978-0544003415")     , i, "eBook", "MOBI", 3.5);
        managebook.addEBook(new Book(i++, "eBook", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427"), i, "eBook", "EPUB", 2.3);
        managebook.addEBook(new Book(i++, "eBook", "The Chronicles of Narnia", "C.S. Lewis", "978-0066238500")      , i, "eBook", "PDF", 1.8);
        managebook.addEBook(new Book(i++, "eBook", "Animal Farm", "978-0451526342")                                        , i, "eBook", "MOBI", 1.2);
        managebook.addEBook(new Book(i++, "eBook", "The Book Thief", "Markus Zusak", "978-0375842207")               , i, "eBook", "PDF", 1.7);
        managebook.addEBook(new Book(i++, "eBook", "The Hunger Games", "Suzanne Collins", "978-0439023481")         , i, "eBook", "EPUB", 1.9);

// Adding Audiobooks

        managebook.addAudioBook(new Book(i++, "audioBook", "The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565")                 , i, "audioBook", "MP3", 100.0, "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "Moby Dick", "Herman Melville", "978-1503280786")                            , i, "audioBook", "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427")   , i, "audioBook", "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "The Hunger Games", "Suzanne Collins", "978-0439023481")                     , i, "audioBook", "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "The Kite Runner", "978-1594631931")                                                , i, "audioBook", "MP3", "AAC", "96kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "The Da Vinci Code", "Dan Brown", "978-0307474278")                          , i, "audioBook", "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "Inferno", "Dan Brown", "978-0385537858")                                    , i, "audioBook", "MP3", "AAC", "192kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "Brave New World", "978-0060850524")                                                 , i, "audioBook", "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "1984", "George Orwell", "978-0451524935")                                   , i, "audioBook", "MP3", "AAC", "128kbps");
        managebook.addAudioBook(new Book(i++, "audioBook", "The Chronicles of Narnia", "C.S. Lewis", "978-0066238500")                  , i, "audioBook", "MP3", "AAC", "96kbps");


        return BookList;
    };
}
