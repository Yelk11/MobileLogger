package m.yelk11.potalogger.dbc.converter;

import androidx.room.TypeConverter;

import java.time.LocalDate;

public class EntryConverter {
    @TypeConverter
    public static LocalDate fromTimestamp(String value) {
        return value == null ? null :  LocalDate.parse(value);
    }

    @TypeConverter
    public static String localDateToTimestamp(LocalDate localDate) {
        return localDate == null ? null : localDate.toString();
    }
}
