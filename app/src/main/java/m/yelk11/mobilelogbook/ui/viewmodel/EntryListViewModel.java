package m.yelk11.mobilelogbook.ui.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.repository.EntryRepository;
import m.yelk11.mobilelogbook.repository.LogbookRepository;

public class EntryListViewModel extends AndroidViewModel {

    private EntryRepository entryRepository;


    public EntryListViewModel(@NonNull Application application) {
        super(application);

        this.entryRepository = new EntryRepository(application);


    }

    public void insert(Entry entry) {
        entryRepository.insert(entry);
    }
    public void update(Entry entry) {
        entryRepository.update(entry);
    }
    public void delete(Entry entry) {
        entryRepository.delete(entry);
    }
    public void deleteAllEntries() {
        entryRepository.deleteAllEntries();
    }
    public LiveData<List<Entry>> getAllEntries() {
        return entryRepository.getAllEntries();
    }
    public LiveData<List<Entry>> getAllBookEntries(int bookId){
        entryRepository.toString();
        return entryRepository.getBookEntries(bookId);
    }

    public void makeFile(Book book){
        entryRepository.makeAdifFile(book);
    }
}
