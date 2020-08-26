package m.yelk11.mobilelogbook.repository;

import android.app.Application;

import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.dbc.entity.Entry;

public class LogbookRepository {

    private BookRepository bookRepository;
    private EntryRepository entryRepository;

    public LogbookRepository(Application application){
        bookRepository = new BookRepository(application);
        entryRepository = new EntryRepository(application);
    }

    public void addBook(Book book){
        bookRepository.insert(book);
    }

    public void insertEntry(Entry entry){
        entryRepository.insert(entry);
    }

    public void insertBook(Book book)
    {
        bookRepository.insert(book);
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
        entryRepository.deleteBookEntries(book.getId());
    }


}
