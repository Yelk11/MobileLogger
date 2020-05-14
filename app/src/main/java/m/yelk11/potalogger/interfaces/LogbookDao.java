package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


import m.yelk11.potalogger.dbc.Logbook;
import m.yelk11.potalogger.dbc.LogbookWithEntries;

@Dao
public interface LogbookDao {


    @Insert
    void insert(Logbook note);

    @Update
    void update(Logbook note);

    @Delete
    void delete(Logbook note);

    @Query("DELETE FROM Logbook")
    void deleteAllLogbooks();

    @Query("SELECT * FROM Logbook")
    LiveData<List<Logbook>> getAllLogbooks();


}
