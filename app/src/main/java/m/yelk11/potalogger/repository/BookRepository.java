package m.yelk11.potalogger.repository;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;


import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

import m.yelk11.potalogger.dbc.LogBookDatabase;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.interfaces.BookDao;

public class BookRepository {

    private BookDao bookDao;
    private EntryRepository entryRepository;

    public BookRepository(Application application){
        LogBookDatabase db = LogBookDatabase.getInstance(application);
        entryRepository = new EntryRepository(application);
        bookDao = db.bookDao();
    }



    public int insert(Book book) {
        InsertLogbookAsyncTask insertLogbookAsyncTask = new InsertLogbookAsyncTask(bookDao);
        insertLogbookAsyncTask.execute(book);

        try {
            return insertLogbookAsyncTask.get();
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

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
        return bookDao.getAllLogbooks();
    }



    public void deleteBook(Book book){
        delete(book);
        entryRepository.deleteBookEntries(book.getId());
    }

    private static class InsertLogbookAsyncTask extends AsyncTask<Book, Void, Integer> {
        private BookDao bookDao;
        private InsertLogbookAsyncTask(BookDao bookDao) {
            this.bookDao = bookDao;
        }
        @Override
        protected Integer doInBackground(Book... books) {
            bookDao.insert(books[0]);
            return books[0].getId();
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
