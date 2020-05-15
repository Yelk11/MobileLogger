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

    public LogbookRepository(){

    }


    public LiveData<List<Logbook>> getLogbooks(){
        return databaseHelper.getLogbooks();
    }

    public LiveData<List<LogbookEntries>> getLogbookEntries(Long id)
    {
        return databaseHelper.loadLogbookEntries(id);
    }

    public void insertEntry(Long logbookId, Entry entry){
        databaseHelper.insertEntry(logbookId, entry);
    }


}
