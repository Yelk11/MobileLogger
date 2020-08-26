package m.yelk11.mobilelogbook.dbc.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int id;


    private String title;
    private String callsign;




    public Book() {

    }

    public Book(String title, String callsign) {
        super();
        this.title = title;
        this.callsign = callsign;
    }

    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }



    public String getTitle() {
        return title;
    }

    public String getCallsign() {
        return callsign;
    }






    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", callsign='" + callsign + '\'' +
                '}';
    }


}
