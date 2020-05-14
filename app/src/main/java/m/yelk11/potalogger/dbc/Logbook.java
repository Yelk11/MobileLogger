package m.yelk11.potalogger.dbc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Logbook {

    @PrimaryKey(autoGenerate = true) public long logbookId;
    public  String name;
    public int age;


    @ColumnInfo(name = "logbook_title")
    private String title;

    @ColumnInfo(name = "date_created")
    private String dateCreated;

    @ColumnInfo(name = "owner_callsign")
    private String ownerCallsign;

    public Logbook(String title, String dateCreated, String ownerCallsign) {
        this.title = title;
        this.dateCreated = dateCreated;
        this.ownerCallsign = ownerCallsign;
    }

    public void setId(int logbookId) {
        this.logbookId = logbookId;
    }

    public long getId() {
        return logbookId;
    }

    public String getTitle() {
        return title;
    }

    public String getDateCreated(){
        return dateCreated;
    }

    public String getOwnerCallsign(){
        return ownerCallsign;
    }


}
