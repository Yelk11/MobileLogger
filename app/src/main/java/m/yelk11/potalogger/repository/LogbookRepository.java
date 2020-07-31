package m.yelk11.potalogger.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;

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
