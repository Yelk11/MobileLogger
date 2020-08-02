package m.yelk11.potalogger.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.LogBookDatabase;


import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.interfaces.EntryDao;

public class EntryRepository {

    private EntryDao entryDao;

    public EntryRepository(Application application){
        LogBookDatabase db = LogBookDatabase.getInstance(application);

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


    public LiveData<List<Entry>> getBookEntries(int bookId){
        return entryDao.getBookEntries(bookId);
    }


//    public LiveData<Entry> getEntry(int entryId){
//        return entryDao.getEntry(entryId);
//    }

    public void deleteBookEntries(int book){
        new DeleteBookEntries(entryDao).execute(book);
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

    private static class DeleteBookEntries extends AsyncTask<Integer, Void, Void> {
        private EntryDao EntryDao;
        private DeleteBookEntries(EntryDao EntryDao) {
            this.EntryDao = EntryDao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            EntryDao.deleteLogEntries(integers[0]);
            return null;
        }
    }


}
