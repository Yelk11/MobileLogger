package m.yelk11.potalogger.dbc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {
    @PrimaryKey
    public int bookId;


    @ColumnInfo(name = "book_name")
    public String bookName;

    @ColumnInfo(name = "last_name")
    public String lastName;
}
