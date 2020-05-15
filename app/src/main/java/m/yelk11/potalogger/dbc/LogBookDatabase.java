package m.yelk11.potalogger.dbc;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.interfaces.LogbookDao;

@Database(entities = {Logbook.class, Entry.class}, version = 1)
public abstract class LogBookDatabase extends RoomDatabase {
    private static LogBookDatabase instance;

    public abstract LogbookDao logbookDao();

    public static synchronized LogBookDatabase getInstance(Context context)
    {
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
            LogBookDatabase.class,"logbook_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
