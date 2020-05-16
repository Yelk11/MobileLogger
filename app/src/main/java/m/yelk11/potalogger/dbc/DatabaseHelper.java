package m.yelk11.potalogger.dbc;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.dbc.entity.LogbookEntries;
import m.yelk11.potalogger.interfaces.LogbookDao;


public class DatabaseHelper {
    private LogbookDao logbookDao;

    public DatabaseHelper(LogBookDatabase database) {
        logbookDao = database.logbookDao();
    }

    public void insertEntryforLogbook(int id, List<Entry> entries) {


        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).setLogbookId(id);
            logbookDao.insert(entries.get(i));
        }
    }

    public  void insertEntry(int logbookId, Entry entry){
        entry.setLogbookId(logbookId);
        logbookDao.insert(entry);
    }


    public LiveData<List<LogbookEntries>> getLogbookEntries(int id) {
        return logbookDao.getLogbookEntries(id);
    }

}
