package m.yelk11.potalogger.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.repository.LogbookRepository;

public class LogbookViewModel extends AndroidViewModel {

    private LogbookRepository mRepository;


    public LogbookViewModel(Application application) {
        super(application);
        this.mRepository = mRepository;
    }


    public LiveData<List<Logbook>> getLogbooks() {
        return mRepository.getLogbooks();
    }

    public void insertLogbook(Logbook logbook)
    {

    }

    public void insertEntry(Long logbookId, Entry entry){

    }
}
