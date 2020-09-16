package m.yelk11.mobilelogbook.ui.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.repository.EntryRepository;

public class NewEntryViewModel extends AndroidViewModel {

    private EntryRepository entryRepository;

    public NewEntryViewModel(@NonNull Application application) {
        super(application);
        entryRepository = new EntryRepository(application);
    }

    public void insert(Entry entry) {
        entryRepository.insert(entry);
    }

    public void update(Entry entry) {
        entryRepository.update(entry);
    }

    public String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(date);
    }

    public void getGridsquare(){
        //TODO: return gridsquare
    }

    public void getDefaultMode(){
        // TODO: return default mode from settings
    }

    public void setDefaultMode(){
        // TODO: set default mode for book only
    }

    public String getMyCallsign(){
        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getApplication().getBaseContext());
        String callsign = sharedPreferences.getString("callsign", "");
        return callsign;
    }

}
