package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;

@Dao
public interface EntryDao {


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
    @Query("SELECT * FROM entry WHERE id = :entryId")
    LiveData<Entry> getEntry(int entryId);

    @Transaction
    @Query("SELECT * FROM entry WHERE logbookId = :logbookId")
    LiveData<List<Entry>> getBookEntries(int logbookId);

    @Transaction
    @Query("DELETE FROM entry WHERE logbookId = :logbookId")
    void deleteLogEntries(int logbookId);

    @Transaction
    @Query("DELETE FROM entry")
    void deleteAllEntries();

    @Transaction
    @Query("SELECT * FROM entry")
    LiveData<List<Entry>> getAllEntries();

    @Transaction
    @Query("SELECT * FROM entry WHERE logbookId = :logbookId")
    List<Entry> getRawBookEntries(int logbookId);
}
