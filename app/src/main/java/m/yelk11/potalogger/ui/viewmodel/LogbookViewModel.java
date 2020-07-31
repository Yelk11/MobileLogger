package m.yelk11.potalogger.ui.viewmodel;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.repository.BookRepository;
import m.yelk11.potalogger.repository.EntryRepository;

public class LogbookViewModel {

    BookRepository bookRepository;
    EntryRepository entryRepository;

    public void addBook(Book book)
    {
        bookRepository.insert(book);
    }
    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    public void deleteBook(int id){

    }
}
