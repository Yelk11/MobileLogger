package m.yelk11.potalogger.fileio;


import android.content.Context;
import android.util.Log;

import org.marsik.ham.adif.Adif3Record;
import org.marsik.ham.adif.AdiWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;


public class AdifHandler {

    public void writeAdif(List<Entry> entries, Context context) {

        AdiWriter writer = new AdiWriter();
        Adif3Record record = new Adif3Record();

        for (int i = 0; i < entries.size(); i++){
            record.setCall(entries.get(i).mCallsignRx); // Their CAllsign
            record.setOperator(entries.get(i).mCallsignTx); // Your Callsign
            record.setComment(entries.get(i).mCommentRx);
            record.setComment(entries.get(i).mCommentTx);
            //record.setQsoDate(Date(entries.get(i).mDate));
            //record.setFreq(entries.get(i).mFrequency));
            record.setGridsquare(entries.get(i).mGridsquareRx); // Their Gridsquare
            record.setMyGridSquare(entries.get(i).mGridsquareTx); // Your Gridsquare
            //record.setMode(entries.get(i).mMode);
            record.setRstRcvd(entries.get(i).mPowerReportRx);
            record.setRstSent(entries.get(i).mPowerReportTx);
            //record.setTimeOn(entries.get(i).mTime);

            writer.append(record);
        }

        try {

            FileOutputStream fOut = context.openFileOutput(
                    "myAdif.txt", Context.MODE_PRIVATE);

            fOut.write(writer.toString().getBytes());
            fOut.close();

        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    public void loadAdif(File file){

    }



}
