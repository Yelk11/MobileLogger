package m.yelk11.potalogger.dbc;


import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.interfaces.EntryDao;


public class EntryDatabaseHelper {
    private EntryDao EntryDao;

    public EntryDatabaseHelper(LogBookDatabase database) {
        EntryDao = database.entryDao();
    }



    public  void insertEntry(int logbookId, Entry entry){
        entry.setLogbookId(logbookId);
        EntryDao.insert(entry);
    }




}
