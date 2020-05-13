package m.yelk11.potalogger.dbc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "logbook_table")
public class Logbook {


    @ColumnInfo(name = "iLogBookId")
    @PrimaryKey(autoGenerate = true)
    private int id;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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
