package m.yelk11.potalogger.fileio;


import android.content.Context;
import android.util.Log;

import org.marsik.ham.adif.Adif3Record;
import org.marsik.ham.adif.AdiWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;


public class AdifHandler {

    public void writeAdif(List<Entry> entries, Context context) {

        AdiWriter writer = new AdiWriter();
        Adif3Record record = new Adif3Record();

        for (int i = 0; i < entries.size(); i++){
            record.setContactedOp(entries.get(i).mCallsignRx);

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
