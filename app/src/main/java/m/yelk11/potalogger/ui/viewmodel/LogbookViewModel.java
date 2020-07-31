package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.repository.BookRepository;
import m.yelk11.potalogger.repository.EntryRepository;
import m.yelk11.potalogger.repository.LogbookRepository;

public class LogbookViewModel extends AndroidViewModel {

    private LogbookRepository logbookRepository;
    private EntryRepository entryRepository;

    public LogbookViewModel(@NonNull Application application) {
        super(application);
        logbookRepository = new LogbookRepository(application);
    }

    public void addBook(Book book)
    {
        logbookRepository.insertBook(book);
    }
    public void deleteBook(Book book){
        logbookRepository.deleteBook(book);
    }

    public void deleteBook(int id){

    }
}
