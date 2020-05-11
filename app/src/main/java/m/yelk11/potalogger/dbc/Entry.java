package m.yelk11.potalogger.dbc;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Entry {
    @PrimaryKey(autoGenerate = true)
    private int entryId;

    public Entry(long bookId, String firstName, String lastName, String address,
                 String addressINTL, String band, String bandRx, String comment,
                 String frequency, String frequencyRx, String gridsquare, String latitude,
                 String longitude, String mode, String name, String operator, String ownerCallsign,
                 String qsoDate, String rxPower, String sotaRef, String stationCallsign,
                 String txPower) {
        this.bookId = bookId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.addressINTL = addressINTL;
        this.band = band;
        this.bandRx = bandRx;
        this.comment = comment;
        this.frequency = frequency;
        this.frequencyRx = frequencyRx;
        this.gridsquare = gridsquare;
        this.latitude = latitude;
        this.longitude = longitude;
        this.mode = mode;
        this.name = name;
        this.operator = operator;
        this.ownerCallsign = ownerCallsign;
        this.qsoDate = qsoDate;
        this.rxPower = rxPower;
        this.sotaRef = sotaRef;
        this.stationCallsign = stationCallsign;
        this.txPower = txPower;
    }


    private long bookId;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "address_INTL")
    private String addressINTL;

    @ColumnInfo(name = "band")
    private String band;

    @ColumnInfo(name = "band_rx")
    private String bandRx;

    @ColumnInfo(name = "comment")
    private String comment;

    @ColumnInfo(name = "freq")
    private String frequency;

    @ColumnInfo(name = "freq_rx")
    private String frequencyRx;

    @ColumnInfo(name = "gridsquare")
    private String gridsquare;

    @ColumnInfo(name = "lat")
    private String latitude;

    @ColumnInfo(name = "lon")
    private String longitude;

    @ColumnInfo(name = "mode")
    private String mode;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "operator")
    private String operator;

    @ColumnInfo(name = "owner_callsign")
    private String ownerCallsign;

    @ColumnInfo(name = "qso_date")
    private String qsoDate;

    @ColumnInfo(name = "rx_pwr")
    private String rxPower;

    @ColumnInfo(name = "sota_ref")
    private String sotaRef;

    @ColumnInfo(name = "station_callsign")
    private String stationCallsign;

    @ColumnInfo(name = "tx_pwr")
    private String txPower;

    public int getEntryId() {
        return entryId;
    }

    public long getBookId() {
        return bookId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getAddressINTL() {
        return addressINTL;
    }

    public String getBand() {
        return band;
    }

    public String getBandRx() {
        return bandRx;
    }

    public String getComment() {
        return comment;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getFrequencyRx() {
        return frequencyRx;
    }

    public String getGridsquare() {
        return gridsquare;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getMode() {
        return mode;
    }

    public String getName() {
        return name;
    }

    public String getOperator() {
        return operator;
    }

    public String getOwnerCallsign() {
        return ownerCallsign;
    }

    public String getQsoDate() {
        return qsoDate;
    }

    public String getRxPower() {
        return rxPower;
    }

    public String getSotaRef() {
        return sotaRef;
    }

    public String getStationCallsign() {
        return stationCallsign;
    }

    public String getTxPower() {
        return txPower;
    }
}
