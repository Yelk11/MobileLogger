package m.yelk11.mobilelogbook.repository;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;


import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.mobilelogbook.dbc.LogBookDatabase;
import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.interfaces.BookDao;

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
    public LiveData<Book> getLastBook() {
        return bookDao.getLastBook();
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
