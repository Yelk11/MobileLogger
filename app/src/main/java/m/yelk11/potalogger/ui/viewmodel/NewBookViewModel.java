package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.repository.BookRepository;

public class NewBookViewModel extends AndroidViewModel {

    private BookRepository bookRepository;


    public NewBookViewModel(@NonNull Application application) {
        super(application);
        bookRepository = new BookRepository(application);
    }

    public int insert(Book book) {
        return bookRepository.insert(book);
    }


}
