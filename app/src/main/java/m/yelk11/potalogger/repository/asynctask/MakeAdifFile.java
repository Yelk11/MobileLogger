package m.yelk11.potalogger.repository.asynctask;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import m.yelk11.potalogger.adif.WriteADIF;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.interfaces.EntryDao;
import m.yelk11.potalogger.ui.activities.MainActivity;

public class MakeAdifFile extends AsyncTask<Book, Void, Void> {
    private EntryDao EntryDao;
    private Application application;
    private static final String TAG = "MakeAdifFile";

    public MakeAdifFile(EntryDao EntryDao, Application application) {
        this.application = application;
        this.EntryDao = EntryDao;
    }

    @Override
    protected Void doInBackground(Book... books) {
        Log.d(TAG, "JustStarted");
        WriteADIF writeADIF = new WriteADIF(application);
        List<Entry> entryList = EntryDao.getRawBookEntries(books[0].getId());
        String str = writeADIF.write(books[0], entryList);
        Log.d(TAG, str);
        File path = new File(application.getApplicationContext().getFilesDir(), "/logbooks");

        if(!path.exists()){
            path.mkdirs();
        }

        File file = new File(path,"other.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
//                    application.openFileOutput("test.adi", Context.MODE_PRIVATE)); //TODO: change file name to fit the book name

            outputStreamWriter.write(str);

            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e(TAG, "File write failed: " + e.toString());
            e.printStackTrace();
        }







        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("", "AllDone");
    }
}