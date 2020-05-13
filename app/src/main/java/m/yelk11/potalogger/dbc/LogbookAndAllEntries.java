package m.yelk11.potalogger.dbc;

import androidx.room.Relation;

import java.util.List;

public class LogbookAndAllEntries {

    int logbook_id;

    @Relation(parentColumn = "logbook_id", entityColumn = "entry_id")
    List<Entry> entries;
}
