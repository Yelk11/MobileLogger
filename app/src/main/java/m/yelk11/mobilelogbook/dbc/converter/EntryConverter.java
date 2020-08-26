package m.yelk11.mobilelogbook.dbc.converter;

import androidx.room.TypeConverter;

import org.marsik.ham.adif.enums.Band;

import java.time.LocalDate;

public class EntryConverter {
    @TypeConverter
    public static LocalDate fromTimestamp(String value) {
        return value == null ? null :  LocalDate.parse(value);
    }

    @TypeConverter
    public static String localDateToTimestamp(LocalDate localDate) {
        return localDate.toString();
    }


    @TypeConverter
    public static Band stringToBand(String value) {
        return Band.findByCode(value);
    }

    @TypeConverter
    public static String bandToString(Band band) {
        switch (band){
            case BAND_2190m:
                return "2190m";
            case BAND_630m:
                return "630m";
            case BAND_560m:
                return "560m";
            case BAND_160m:
                return "160m";
            case BAND_80m:
                return "80m";
            case BAND_70cm:
                return "70m";
            case BAND_60m:
                return "60m";
            case BAND_40m:
                return "40m";
            case BAND_33cm:
                return "33cm";
            case BAND_30m:
                return "30m";
            case BAND_23cm:
                return "23cm";
            case BAND_20m:
                return "20m";
            case BAND_17m:
                return "17m";
            case BAND_15m:
                return "15m";
            case BAND_13cm:
                return "13cm";
            case BAND_12m:
                return "12m";
            case BAND_10m:
                return "10m";
            case BAND_9cm:
                return "9cm";
            case BAND_6mm:
                return "6mm";
            case BAND_6m:
                return "6m";
            case BAND_6cm:
                return "6cm";
            case BAND_4mm:
                return "4mm";
            case BAND_4m:
                return "4m";
            case BAND_3cm:
                return "3cm";
            case BAND_2mm:
                return "2mm";
            case BAND_2m:
                return "2m";
            case BAND_2_5mm:
                return "2.5mm";
            case BAND_1mm:
                return "1mm";
            case BAND_1_25m:
                return "1.25m";
            case BAND_1_25cm:
                return "1.25cm";
            default:
                return null;
        }

    }
}
