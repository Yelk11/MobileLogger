package m.yelk11.potalogger.dbc;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class LogbookWithEntries {

    @Embedded public Logbook logbook;
    @Relation(
            parentColumn = "logbookId",
            entityColumn = "logbookCreatorId"
    )
    public List<Entry> entries;


}
