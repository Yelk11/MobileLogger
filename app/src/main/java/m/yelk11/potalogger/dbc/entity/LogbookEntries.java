package m.yelk11.potalogger.dbc.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;


public class LogbookEntries {

    @Embedded
    public Logbook logbook;


    @Relation(
            parentColumn = "id",
            entityColumn = "logbookId",
            entity = Entry.class
    )
    public List<Entry> entries;

    public Logbook getLogbook()
    {
        return logbook;
    }

    public void setLogbook(Logbook logbook){
        this.logbook = logbook;
    }

    public List<Entry> getEntries(){
        return entries;
    }

    public void setEntries(List<Entry> entries){
        this.entries = entries;
    }


    public String toString() {
        return "Logbook Entries{" +
                "logbook" + logbook +
                ", entries=" + entries +
                '}';
    }



}
