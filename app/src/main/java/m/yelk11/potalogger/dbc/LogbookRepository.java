package m.yelk11.potalogger.dbc;

import android.app.Application;
import android.os.AsyncTask;


import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.interfaces.LogbookDao;

public class LogbookRepository {
    private LogbookDao logbookDao;
    private LiveData<List<Logbook>> allLogbooks;

    public LogbookRepository(Application application){
        LogBookDatabase database = LogBookDatabase.getInstance(application);
        logbookDao = database.logbookDao();
        allLogbooks = logbookDao.getAllLogbooks();
    }

    public void insert(Logbook logbook)
    {
        new InsertLogbookAsyncTask(logbookDao).execute(logbook);
    }

    public void update(Logbook logbook){
        new UpdateLogbookAsyncTask(logbookDao).execute(logbook);
    }

    public void delete(Logbook logbook){
        new DeleteLogbookAsyncTask(logbookDao).execute(logbook);
    }

    public void deleteAllLogbooks()
    {
        new DeleteAllLogbookAsyncTask(logbookDao).execute();
    }

    public LiveData<List<Logbook>> getAllLogbooks() {
        return allLogbooks;
    }

    private static class InsertLogbookAsyncTask extends AsyncTask<Logbook, Void, Void>{
        private LogbookDao logbookDao;
        private InsertLogbookAsyncTask(LogbookDao logbookDao){
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.insert(logbooks[0]);
            return null;
        }
    }

    private static class UpdateLogbookAsyncTask extends AsyncTask<Logbook, Void, Void>{
        private LogbookDao logbookDao;
        private UpdateLogbookAsyncTask(LogbookDao logbookDao){
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.update(logbooks[0]);
            return null;
        }
    }

    private static class DeleteLogbookAsyncTask extends AsyncTask<Logbook, Void, Void>{
        private LogbookDao logbookDao;
        private DeleteLogbookAsyncTask(LogbookDao logbookDao){
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.delete(logbooks[0]);
            return null;
        }
    }

    private static class DeleteAllLogbookAsyncTask extends AsyncTask<Logbook, Void, Void>{
        private LogbookDao logbookDao;
        private DeleteAllLogbookAsyncTask(LogbookDao logbookDao){
            this.logbookDao = logbookDao;
        }
        @Override
        protected Void doInBackground(Logbook... logbooks) {
            logbookDao.deleteAllLogbooks();
            return null;
        }
    }


}
