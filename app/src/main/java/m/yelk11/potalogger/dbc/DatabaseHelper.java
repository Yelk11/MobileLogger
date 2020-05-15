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

    private void insertEntryforLogbook(Long id, List<Entry> entries) {
        if (id == null) throw new NullPointerException();

        for (int i = 0; i < entries.size(); i++) {
            entries.get(i).setLogbookId(id);
        }
    }

    public void saveLogbook(Logbook logbook) {
        Long id = logbookDao.saveLogbook(logbook);
        insertEntryforLogbook(id, logbook.getEntries());
    }

    public void setLogbookDao(LogbookDao logbookDao) {
        this.logbookDao = logbookDao;
    }

    public LogbookDao getLogbookDao() {
        return logbookDao;
    }

    public LiveData<List<Logbook>> getLogbooks() {
        return logbookDao.getLogbooks();
    }

    public LiveData<List<LogbookEntries>> loadLogbookEntries(Long id) {
        return logbookDao.loadLogbookEntries(id);
    }

    public void insertEntry(Long logbookId, Entry entry) {
        logbookDao.insertLogbookwithEntry(logbookId, entry);
    }
}
