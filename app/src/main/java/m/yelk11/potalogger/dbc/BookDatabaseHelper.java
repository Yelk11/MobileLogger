package m.yelk11.potalogger.dbc;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.interfaces.BookDao;


public class BookDatabaseHelper {
    private BookDao bookDao;

    public BookDatabaseHelper(LogBookDatabase database) {
        bookDao = database.bookDao();
    }

    public void insertBook(Book book){
        bookDao.insert(book);
    }


}
