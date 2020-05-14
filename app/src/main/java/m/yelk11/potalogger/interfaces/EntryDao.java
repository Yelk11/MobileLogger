package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import m.yelk11.potalogger.dbc.Entry;
import m.yelk11.potalogger.dbc.LogbookWithEntries;

@Dao
public interface EntryDao {

    @Insert
    void insert(Entry entry);


    @Update
    void update(Entry entry);

    @Delete
    void delete(Entry entry);

    @Query("DELETE FROM Entry")
    void deleteAllEntries();

    @Query("SELECT * FROM Entry")
    LiveData<List<Entry>> getAllEntries();

    @Transaction
    @Query("SELECT * FROM Logbook")
    LiveData<List<LogbookWithEntries>> getLogbookEntries();

}
