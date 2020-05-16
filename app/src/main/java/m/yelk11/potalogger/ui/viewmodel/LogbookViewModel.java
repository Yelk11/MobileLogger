package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.dbc.entity.LogbookEntries;
import m.yelk11.potalogger.repository.LogbookRepository;

public class LogbookViewModel extends AndroidViewModel {

    private LogbookRepository mRepository;
    private LiveData<List<Logbook>> allLogbooks;
    private LiveData<List<Entry>> allEntries;

    public LogbookViewModel(Application application) {
        super(application);
        this.mRepository = new LogbookRepository(getApplication());
        allLogbooks = mRepository.getAllLogbooks();
        allEntries = mRepository.getAllEntries();
    }


    /**
     *
     *        LOGBOOK
     *
     *
     */


    public void insert(Logbook logbook) {
        mRepository.insert(logbook);
    }
    public void update(Logbook logbook) {
        mRepository.update(logbook);
    }
    public void delete(Logbook logbook) {
        mRepository.delete(logbook);
    }
    public void deleteAllLogbooks() {
        mRepository.deleteAllLogbooks();
    }
    public LiveData<List<Logbook>> getAllLogbooks() {
        return allLogbooks;
    }

    /**
     *
     *        ENTRIES
     *
     *
     */

    public void insert(Entry entry) {
        mRepository.insert(entry);
    }
    public void update(Entry entry) {
        mRepository.update(entry);
    }
    public void delete(Entry entry) {
        mRepository.delete(entry);
    }
    public void deleteAllEntries() {
        mRepository.deleteAllEntries();
    }
    public LiveData<List<Entry>> getAllEntries() {
        return allEntries;
    }





    /**
     *
     *        LOGBOOK_ENTRIES
     *
     *
     */

    public LiveData<List<LogbookEntries>> getLogbookEntries(){
        return mRepository.getLogbookEntries();
    }

    public LiveData<List<Entry>> findEntriesForLogbook(int id){
        return mRepository.findEntriesForLogbook(id);
    }
}
