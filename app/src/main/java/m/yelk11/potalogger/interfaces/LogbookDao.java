package m.yelk11.potalogger.interfaces;

import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import m.yelk11.potalogger.dbc.Logbook;
import m.yelk11.potalogger.dbc.LogbookAndAllEntries;

@Dao
public interface LogbookDao {


    @Insert
    void insert(Logbook note);

    @Update
    void update(Logbook note);

    @Delete
    void delete(Logbook note);

    @Query("DELETE FROM logbook_table")
    void deleteAllLogbooks();

    @Query("SELECT * FROM logbook_table")
    LiveData<List<Logbook>> getAllLogbooks();

    @Query("SELECT id, name FROM Album")
    List<LogbookAndAllEntries> loadAlbumAndSongs();

}
