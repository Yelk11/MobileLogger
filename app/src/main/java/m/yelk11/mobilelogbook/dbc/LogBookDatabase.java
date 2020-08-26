package m.yelk11.mobilelogbook.dbc;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.interfaces.BookDao;
import m.yelk11.mobilelogbook.interfaces.EntryDao;

@Database(entities = {Book.class, Entry.class}, version = 1)
public abstract class LogBookDatabase extends RoomDatabase {
    private static LogBookDatabase instance;

    public abstract BookDao bookDao();
    public abstract EntryDao entryDao();

    public static synchronized LogBookDatabase getInstance(Context context)
    {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
            LogBookDatabase.class,"test_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
