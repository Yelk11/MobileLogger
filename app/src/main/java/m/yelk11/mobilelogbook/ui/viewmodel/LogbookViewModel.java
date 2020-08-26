package m.yelk11.mobilelogbook.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.repository.EntryRepository;
import m.yelk11.mobilelogbook.repository.LogbookRepository;

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
