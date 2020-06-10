package m.yelk11.potalogger.repository;

import android.app.Activity;
import android.app.Application;
import android.os.AsyncTask;
import android.os.Build;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;

import org.reactivestreams.Publisher;

import java.util.List;

import m.yelk11.potalogger.dbc.DatabaseHelper;
import m.yelk11.potalogger.dbc.LogBookDatabase;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.dbc.entity.LogbookEntries;
import m.yelk11.potalogger.interfaces.LogbookDao;

public class LogbookRepository {

    private LogbookDao logbookDao;
    private DatabaseHelper databaseHelper;

    private LiveData<List<Logbook>> allLogbooks;
    private LiveData<List<LogbookEntries>> allLogbookEntries;

    public LogbookRepository(Application application){
        LogBookDatabase db = LogBookDatabase.getInstance(application);
        databaseHelper = new DatabaseHelper(db);
        logbookDao = db.logbookDao();

    }



    /**
     *
     *        LOGBOOK
     *
     *
     */
    public void insert(Logbook logbook) {
        new InsertLogbookAsyncTask(logbookDao).execute(logbook);
    }
    public void update(Logbook logbook) {
        new UpdateLogbookAsyncTask(logbookDao).execute(logbook);
    }
    public void delete(Logbook logbook) {
        new DeleteLogbookAsyncTask(logbookDao).execute(logbook);
    }
    public void deleteAllLogbooks() {
        new DeleteAllLogbooksAsyncTask(logbookDao).execute();
    }

    public LiveData<List<Logbook>> getAllLogbooks() {
        return logbookDao.getAllLogbooks();
    }


    private static class InsertLogbookAsyncTask extends AsyncTask<Logbook, Void, Void> {
        private LogbookDao logbookDao;
        private InsertLogbookAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.insert(logbooks[0]);
            return null;
        }
    }
    private static class UpdateLogbookAsyncTask extends AsyncTask<Logbook, Void, Void> {
        private LogbookDao logbookDao;
        private UpdateLogbookAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.update(logbooks[0]);
            return null;
        }
    }
    private static class DeleteLogbookAsyncTask extends AsyncTask<Logbook, Void, Void> {
        private LogbookDao logbookDao;
        private DeleteLogbookAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.delete(logbooks[0]);
            return null;
        }
    }
    private static class DeleteAllLogbooksAsyncTask extends AsyncTask<Void, Void, Void> {
        private LogbookDao logbookDao;
        private DeleteAllLogbooksAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            logbookDao.deleteAllLogbooks();
            return null;
        }
    }


    /**
     *
     *        ENTRIES
     *
     *
     */

    public void insert(Entry entry) {
        new InsertEntryAsyncTask(logbookDao).execute(entry);
    }
    public void update(Entry entry) {
        new UpdateEntryAsyncTask(logbookDao).execute(entry);
    }
    public void delete(Entry entry) {
        new DeleteEntryAsyncTask(logbookDao).execute(entry);
    }
    public void deleteAllEntries() {
        new DeleteAllEntriesAsyncTask(logbookDao).execute();
    }

    public LiveData<List<Entry>> getAllEntries() {
        return logbookDao.getAllEntries();
    }


    private static class InsertEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private LogbookDao logbookDao;
        private InsertEntryAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            logbookDao.insert(entries[0]);
            return null;
        }
    }
    private static class UpdateEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private LogbookDao logbookDao;
        private UpdateEntryAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            logbookDao.update(entries[0]);
            return null;
        }
    }
    private static class DeleteEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private LogbookDao logbookDao;
        private DeleteEntryAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            logbookDao.delete(entries[0]);
            return null;
        }
    }
    private static class DeleteAllEntriesAsyncTask extends AsyncTask<Void, Void, Void> {
        private LogbookDao logbookDao;
        private DeleteAllEntriesAsyncTask(LogbookDao logbookDao) {
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            logbookDao.deleteAllEntries();
            return null;
        }
    }
    /**
     *
     *        LOGBOOK_ENTRIES
     *
     *
     */
    public LiveData<List<LogbookEntries>> getLogbookEntries()
    {
        return logbookDao.getLogbookEntries();
    }

    public LiveData<List<Entry>> findEntriesForLogbook(int id)
    {
        return logbookDao.findEntriesForLogbook(id);
    }
}