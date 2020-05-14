package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.Entry;
import m.yelk11.potalogger.dbc.EntryRepository;
import m.yelk11.potalogger.dbc.LogbookWithEntries;

public class EntryVM extends AndroidViewModel {

    private EntryRepository repository;
    private LiveData<List<Entry>> allEntries;
    private LiveData<List<LogbookWithEntries>> logbookEntries;
    private int logbookId;

    public EntryVM(@NonNull Application application){
        super(application);
        repository = new EntryRepository(application);
        allEntries = repository.getAllEntries();
        logbookEntries = repository.getLogbookEntries();
    }

    public void insert(Entry entry){
        repository.insert(entry);
    }

    public void update(Entry entry){
        repository.update(entry);
    }

    public void delete(Entry entry){
        repository.delete(entry);
    }

    public void deleteAllLogbooks(){
        repository.deleteAllLogbooks();
    }

    public LiveData<List<Entry>> getAllEntries(){
        return allEntries;
    }


    public void setLogbookId(int logbookId){
        this.logbookId = logbookId;
    }

    public LiveData<List<LogbookWithEntries>> getLogbookEntries(){
        return logbookEntries;
    }
}
