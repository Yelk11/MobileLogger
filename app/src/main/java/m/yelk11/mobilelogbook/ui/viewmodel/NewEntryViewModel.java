package m.yelk11.mobilelogbook.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

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
}
