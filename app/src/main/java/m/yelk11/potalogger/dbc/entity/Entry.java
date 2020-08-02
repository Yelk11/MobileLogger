package m.yelk11.potalogger.dbc.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;


@Entity
public class Entry {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ForeignKey
            (entity = Book.class,
                    parentColumns = "id",
                    childColumns = "logbookId",
                    onDelete = CASCADE)
    private int logbookId;


    public String mDate;
    public String mTime;
    public String mFrequency;
    public String mMode;
    public String mCallsignTx;
    public String mCallsignRx;
    public String mPowerReportTx;
    public String mPowerReportRx;
    public String mSignalReportTx;
    public String mSignalReportRx;
    public String mGridsquareTx;
    public String mGridsquareRx;
    public String mCommentTx;
    public String mCommentRx;


    public Entry() {

    }

    public Entry(String mDate, String mTime, String mFrequency, String mMode,
                 String mCallsignTx, String mCallsignRx, String mPowerReportTx,
                 String mPowerReportRx, String mSignalReportTx, String mSignalReportRx,
                 String mGridsquareTx, String mGridsquareRx, String mCommentTx,
                 String mCommentRx) {
        super();
        this.mDate = mDate;
        this.mTime = mTime;
        this.mFrequency = mFrequency;
        this.mMode = mMode;
        this.mCallsignTx = mCallsignTx;
        this.mCallsignRx = mCallsignRx;
        this.mPowerReportTx = mPowerReportTx;
        this.mPowerReportRx = mPowerReportRx;
        this.mSignalReportTx = mSignalReportTx;
        this.mSignalReportRx = mSignalReportRx;
        this.mGridsquareTx = mGridsquareTx;
        this.mGridsquareRx = mGridsquareRx;
        this.mCommentTx = mCommentTx;
        this.mCommentRx = mCommentRx;
    }

    public int getId() {
        return this.id;
    }
    public int getLogbookId() {
        return logbookId;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setLogbookId(int logbookId){
        this.logbookId = logbookId;
    }


    public String getmDate() {
        return this.mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmFrequency() {
        return mFrequency;
    }

    public void setmFrequency(String mFrequency) {
        this.mFrequency = mFrequency;
    }

    public String getmMode() {
        return mMode;
    }

    public void setmMode(String mMode) {
        this.mMode = mMode;
    }

    public String getmCallsignTx() {
        return mCallsignTx;
    }

    public void setmCallsignTx(String mCallsignTx) {
        this.mCallsignTx = mCallsignTx;
    }

    public String getmCallsignRx() {
        return mCallsignRx;
    }

    public void setmCallsignRx(String mCallsignRx) {
        this.mCallsignRx = mCallsignRx;
    }

    public String getmPowerReportTx() {
        return mPowerReportTx;
    }

    public void setmPowerReportTx(String mPowerReportTx) {
        this.mPowerReportTx = mPowerReportTx;
    }

    public String getmPowerReportRx() {
        return mPowerReportRx;
    }

    public void setmPowerReportRx(String mPowerReportRx) {
        this.mPowerReportRx = mPowerReportRx;
    }

    public String getmSignalReportTx() {
        return mSignalReportTx;
    }

    public void setmSignalReportTx(String mSignalReportTx) {
        this.mSignalReportTx = mSignalReportTx;
    }

    public String getmSignalReportRx() {
        return mSignalReportRx;
    }

    public void setmSignalReportRx(String mSignalReportRx) {
        this.mSignalReportRx = mSignalReportRx;
    }

    public String getmGridsquareTx() {
        return mGridsquareTx;
    }

    public void setmGridsquareTx(String mGridsquareTx) {
        this.mGridsquareTx = mGridsquareTx;
    }

    public String getmGridsquareRx() {
        return mGridsquareRx;
    }

    public void setmGridsquareRx(String mGridsquareRx) {
        this.mGridsquareRx = mGridsquareRx;
    }

    public String getmCommentTx() {
        return mCommentTx;
    }

    public void setmCommentTx(String mCommentTx) {
        this.mCommentTx = mCommentTx;
    }

    public String getmCommentRx() {
        return mCommentRx;
    }

    public void setmCommentRx(String mCommentRx) {
        this.mCommentRx = mCommentRx;
    }
}
