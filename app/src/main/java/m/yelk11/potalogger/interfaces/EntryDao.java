package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import m.yelk11.potalogger.dbc.Entry;

@Dao
public interface EntryDao {

    @Insert
    void insert(Entry entry);

    @Update
    void update(Entry entry);

    @Delete
    void delete(Entry entry);

    @Query("DELETE FROM entry_table")
    void deleteAllLogbooks();

    @Query("SELECT * FROM entry_table")
    LiveData<List<Entry>> getAllEntries();


}
