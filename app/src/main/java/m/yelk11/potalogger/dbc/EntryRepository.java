package m.yelk11.potalogger.dbc;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.interfaces.EntryDao;

public class EntryRepository {
    private EntryDao entryDao;
    private LiveData<List<Entry>> allEntries;

    public EntryRepository(Application application){
        LogBookDatabase database = LogBookDatabase.getInstance(application);
        entryDao = database.entryDao();
        allEntries = entryDao.getAllEntries();
    }

    public void insert(Entry entry)
    {
        new EntryRepository.InsertEntryAsyncTask(entryDao).execute(entry);
    }

    public void update(Entry entry){
        new EntryRepository.UpdateEntryAsyncTask(entryDao).execute(entry);
    }

    public void delete(Entry entry){
        new EntryRepository.DeleteEntryAsyncTask(entryDao).execute(entry);
    }

    public void deleteAllLogbooks()
    {
        new EntryRepository.DeleteEntryAsyncTask(entryDao).execute();
    }


    public LiveData<List<Entry>> getAllEntries(){
        return allEntries;
    }

    public LiveData<List<LogbookWithEntries>> getLogbookEntries()
    {
        return entryDao.getLogbookEntries();
    }

    private static class InsertEntryAsyncTask extends AsyncTask<Entry, Void, Void> {
        private EntryDao entryDao;
        private InsertEntryAsyncTask(EntryDao entryDao){
            this.entryDao = entryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            entryDao.insert(entries[0]);
            return null;
        }
    }

    private static class UpdateEntryAsyncTask extends AsyncTask<Entry, Void, Void>{
        private EntryDao entryDao;
        private UpdateEntryAsyncTask(EntryDao entryDao){
            this.entryDao = entryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            entryDao.update(entries[0]);
            return null;
        }
    }

    private static class DeleteEntryAsyncTask extends AsyncTask<Entry, Void, Void>{
        private EntryDao entryDao;
        private DeleteEntryAsyncTask(EntryDao entryDao){
            this.entryDao = entryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            entryDao.delete(entries[0]);
            return null;
        }
    }

    private static class DeleteAllEntryAsyncTask extends AsyncTask<Entry, Void, Void>{
        private EntryDao entryDao;
        private DeleteAllEntryAsyncTask(EntryDao entryDao){
            this.entryDao = entryDao;
        }
        @Override
        protected Void doInBackground(Entry... entries) {
            entryDao.deleteAllEntries();
            return null;
        }
    }



}
