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


    //Logbook


    @Transaction
    @Insert
    Long insert(Logbook logbook);

    @Transaction
    @Update
    void update(Logbook logbook);

    @Transaction
    @Delete
    void delete(Logbook logbook);

    @Transaction
    @Query("DELETE FROM logbook")
    void deleteAllLogbooks();


    @Transaction
    @Query("SELECT * FROM logbook")
    LiveData<List<Logbook>> getAllLogbooks();


    // Entries

    @Transaction
    @Insert
    Long insert(Entry entry);

    @Transaction
    @Update
    void update(Entry entry);

    @Transaction
    @Delete
    void delete(Entry entry);

    @Transaction
    @Query("DELETE FROM entry")
    void deleteAllEntries();


    @Transaction
    @Query("SELECT * FROM entry")
    LiveData<List<Entry>> getAllEntries();



    // POJO
    @Transaction
    @Query("SELECT * FROM logbook")
    LiveData<List<LogbookEntries>> getLogbookEntries();


    @Query("SELECT * FROM entry WHERE logbookId=:logbookId")
    LiveData<List<Entry>> findEntriesForLogbook(int logbookId);
}