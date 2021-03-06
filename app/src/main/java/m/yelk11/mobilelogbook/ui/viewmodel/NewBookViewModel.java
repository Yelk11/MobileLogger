package m.yelk11.mobilelogbook.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.repository.BookRepository;

public class NewBookViewModel extends AndroidViewModel {

    private BookRepository bookRepository;


    public NewBookViewModel(@NonNull Application application) {
        super(application);
        bookRepository = new BookRepository(application);
    }

    public LiveData<Book> getLastBook(){
        return bookRepository.getLastBook();
    }

    public int insert(Book book) {
        return bookRepository.insert(book);
    }


}
