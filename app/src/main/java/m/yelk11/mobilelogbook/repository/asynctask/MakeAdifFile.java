package m.yelk11.mobilelogbook.repository.asynctask;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import m.yelk11.mobilelogbook.BuildConfig;
import m.yelk11.mobilelogbook.R;
import m.yelk11.mobilelogbook.adif.WriteADIF;
import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.interfaces.EntryDao;
import m.yelk11.mobilelogbook.ui.fragments.EntryListFragment;

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
        Log.d(TAG, "Start ADIF create");
        WriteADIF writeADIF = new WriteADIF(application);
        List<Entry> entryList = EntryDao.getRawBookEntries(books[0].getId());
        String str = writeADIF.write(books[0], entryList);
        File path = new File(application.getApplicationContext().getFilesDir(), "/logbooks");

        if (!path.exists()) {
            path.mkdirs();
        }

        File file = new File(path, books[0].getTitle() + ".txt");

        try {
            // Create Adif File
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fos);
            outputStreamWriter.write(str);
            outputStreamWriter.close();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            File fileRoot = new File(application
                    .getApplicationContext().getFilesDir(), "logbooks/");
            File filePath = new File(fileRoot, books[0].getTitle() + ".txt");


            Uri uri = FileProvider.getUriForFile(application
                            .getApplicationContext(),
                    BuildConfig.APPLICATION_ID + ".provider",
                    filePath);

            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_STREAM, uri);

            //intent.setData(uri);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Intent chooser = Intent.createChooser(intent,
                    application.getString(R.string.chooser_title));
            chooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            application.startActivity(chooser);
        } catch (IOException e) {
            Log.e(TAG, "Failed to create ADIF file " + e.toString());
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}