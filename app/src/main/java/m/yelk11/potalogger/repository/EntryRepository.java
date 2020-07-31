package m.yelk11.potalogger.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.BookDatabaseHelper;
import m.yelk11.potalogger.dbc.LogBookDatabase;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.interfaces.EntryDao;

public class EntryRepository {

    private EntryDao entryDao;
    private BookDatabaseHelper bookDatabaseHelper;

    private LiveData<List<Book>> allLogbooks;

    public EntryRepository(Application application){
        LogBookDatabase db = LogBookDatabase.getInstance(application);
        bookDatabaseHelper = new BookDatabaseHelper(db);
        entryDao = db.entryDao();
    }

    public void insert(Entry entry) {
        new InsertEntryAsyncTask(entryDao).execute(entry);
    }
    public void update(Entry entry) {
        new UpdateEntryAsyncTask(entryDao).execute(entry);
    }
    public void delete(Entry entry) {
        new DeleteEntryAsyncTask(entryDao).execute(entry);
    }
    public void deleteAllEntries() {
        new DeleteAllEntriesAsyncTask(entryDao).execute();
    }

    public LiveData<List<Entry>> getAllEntries() {
        return entryDao.getAllEntries();
    }


    private static class InsertEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private EntryDao EntryDao;
        private InsertEntryAsyncTask(EntryDao EntryDao) {
            this.EntryDao = EntryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            EntryDao.insert(entries[0]);
            return null;
        }
    }
    private static class UpdateEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private EntryDao EntryDao;
        private UpdateEntryAsyncTask(EntryDao EntryDao) {
            this.EntryDao = EntryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            EntryDao.update(entries[0]);
            return null;
        }
    }

    private static class DeleteEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private EntryDao EntryDao;
        private DeleteEntryAsyncTask(EntryDao EntryDao) {
            this.EntryDao = EntryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            EntryDao.delete(entries[0]);
            return null;
        }
    }

    private static class DeleteAllEntriesAsyncTask extends AsyncTask<Void, Void, Void> {
        private EntryDao EntryDao;
        private DeleteAllEntriesAsyncTask(EntryDao EntryDao) {
            this.EntryDao = EntryDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            EntryDao.deleteAllEntries();
            return null;
        }
    }
}
