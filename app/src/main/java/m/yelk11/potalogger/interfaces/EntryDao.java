package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;

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
    @Query("SELECT * FROM entry WHERE id")
    void get(int id);

    @Transaction
    @Query("DELETE FROM entry")
    void deleteAllEntries();


    @Transaction
    @Query("SELECT * FROM entry")
    LiveData<List<Entry>> getAllEntries();
}
