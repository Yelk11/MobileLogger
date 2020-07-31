package m.yelk11.potalogger.ui.viewmodel;

import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.repository.EntryRepository;

public class EntryViewModel {

    EntryRepository mRepository;

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
        return mRepository.getAllEntries();
    }


}
