package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.repository.BookRepository;

public class BookListViewModel extends AndroidViewModel {

    private BookRepository bookRepository;
    private LiveData<List<Book>> allBooks;


    public BookListViewModel(@NonNull Application application) {
        super(application);
        this.bookRepository = new BookRepository(application);
        allBooks = bookRepository.getAllBooks();
    }


    public void insert(Book book) {
        bookRepository.insert(book);
    }
    public void update(Book book) {
        bookRepository.update(book);
    }
    public void delete(Book book) {
        bookRepository.deleteBook(book);
    }
    public void deleteAllLogbooks() {
        bookRepository.deleteAllLogbooks();
    }
    public LiveData<List<Book>> getAllLogbooks() {
        return allBooks;
    }
}
