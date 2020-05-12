package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.Entry;
import m.yelk11.potalogger.dbc.EntryRepository;

public class EntryVM extends AndroidViewModel {

    private EntryRepository repository;
    private LiveData<List<Entry>> allEntries;

    public EntryVM(@NonNull Application application){
        super(application);
        repository = new EntryRepository(application);
        allEntries = repository.getAllEntries();
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
}
