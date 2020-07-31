package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.repository.BookRepository;

public class BookViewModel extends AndroidViewModel {

    private BookRepository mRepository;
    private LiveData<List<Book>> allBooks;

    public BookViewModel(Application application) {
        super(application);
        this.mRepository = new BookRepository(getApplication());
        allBooks = mRepository.getAllBooks();
    }


    public void insert(Book book) {
        mRepository.insert(book);
    }
    public void update(Book book) {
        mRepository.update(book);
    }
    public void delete(Book book) {
        mRepository.delete(book);
    }
    public void deleteAllLogbooks() {
        mRepository.deleteAllLogbooks();
    }
    public LiveData<List<Book>> getAllLogbooks() {
        return allBooks;
    }








}
