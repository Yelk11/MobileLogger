package m.yelk11.potalogger.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;


import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;

@Dao
public interface BookDao {

    @Transaction
    @Insert
    Long insert(Book book);

    @Transaction
    @Update
    void update(Book book);

    @Transaction
    @Delete
    void delete(Book book);

    @Transaction
    @Query("DELETE FROM Book")
    void deleteAllLogbooks();


    @Transaction
    @Query("SELECT * FROM Book")
    LiveData<List<Book>> getAllLogbooks();


    @Query("SELECT * FROM entry WHERE logbookId=:logbookId")
    LiveData<List<Entry>> findEntriesForLogbook(int logbookId);
}