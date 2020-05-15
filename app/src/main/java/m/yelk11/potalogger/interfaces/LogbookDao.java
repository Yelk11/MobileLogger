package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;


import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.dbc.entity.LogbookEntries;

@Dao
public interface LogbookDao {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long saveLogbook(Logbook logbook);

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveLogbook(List<Logbook> logbooks);

    @Transaction
    @Query("SELECT * FROM logbook WHERE id = :logbookId")
    LiveData<Logbook> getLogbook(Long logbookId);

    @Transaction
    @Query("SELECT * FROM logbook")
    LiveData<List<Logbook>> getLogbooks();


    // Entries

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveEntry(Entry entry);

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveEntries(List<Entry> entries);


    //delete
    @Transaction
    @Query("DELETE FROM logbook")
    void deleteLogbooks();



    // POJO
    @Transaction
    @Query("SELECT * FROM logbook WHERE id = :logbookId")
    LiveData<List<LogbookEntries>> loadLogbookEntries(Long logbookId);


    @Insert
    void insertLogbookwithEntry(Long logbookId, Entry entry);
}
