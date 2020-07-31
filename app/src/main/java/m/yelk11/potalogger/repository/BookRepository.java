package m.yelk11.potalogger.repository;

import android.app.Application;
import android.os.AsyncTask;


import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.LogBookDatabase;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.interfaces.BookDao;

public class BookRepository {

    private BookDao bookDao;


    private LiveData<List<Book>> allBooks;


    public BookRepository(Application application){
        LogBookDatabase db = LogBookDatabase.getInstance(application);

        bookDao = db.bookDao();
    }



    public void insert(Book book) {
        new InsertLogbookAsyncTask(bookDao).execute(book);
    }
    public void update(Book book) {
        new UpdateLogbookAsyncTask(bookDao).execute(book);
    }
    public void delete(Book book) {
        new DeleteLogbookAsyncTask(bookDao).execute(book);
    }
    public void deleteAllLogbooks() {
        new DeleteAllLogbooksAsyncTask(bookDao).execute();
    }

    public LiveData<List<Book>> getAllBooks() {
        return allBooks;
    }


    private static class InsertLogbookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;
        private InsertLogbookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insert(books[0]);
            return null;
        }
    }
    private static class UpdateLogbookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;
        private UpdateLogbookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.update(books[0]);
            return null;
        }
    }
    private static class DeleteLogbookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;
        private DeleteLogbookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Book... books) {
            bookDao.delete(books[0]);
            return null;
        }
    }
    private static class DeleteAllLogbooksAsyncTask extends AsyncTask<Void, Void, Void> {
        private BookDao bookDao;
        private DeleteAllLogbooksAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAllLogbooks();
            return null;
        }
    }



}
