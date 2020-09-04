package m.yelk11.mobilelogbook.interfaces;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;


import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.dbc.entity.Entry;

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

    @Transaction
    @Query("SELECT * FROM Book ORDER BY ID DESC LIMIT 1")
    LiveData<Book> getLastBook();

    @Query("SELECT * FROM entry WHERE logbookId=:logbookId")
    LiveData<List<Entry>> findEntriesForLogbook(int logbookId);
}