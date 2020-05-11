package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.Logbook;
import m.yelk11.potalogger.dbc.LogbookRepository;

public class LogbookVM extends AndroidViewModel {

    private LogbookRepository repository;
    private LiveData<List<Logbook>> allLogbooks;

    public LogbookVM(@NonNull Application application){
        super(application);
        repository = new LogbookRepository(application);
        allLogbooks = repository.getAllLogbooks();
    }

    public void insert(Logbook logbook){
        repository.insert(logbook);
    }

    public void update(Logbook logbook){
        repository.update(logbook);
    }

    public void delete(Logbook logbook){
        repository.delete(logbook);
    }

    public void deleteAllLogbooks(){
        repository.deleteAllLogbooks();
    }

    public LiveData<List<Logbook>> getAllLogbooks(){
        return allLogbooks;
    }
}
