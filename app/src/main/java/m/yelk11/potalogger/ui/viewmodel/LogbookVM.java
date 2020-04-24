package m.yelk11.potalogger.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import m.yelk11.potalogger.models.LogEntry;
import m.yelk11.potalogger.models.Logbook;

public class LogbookVM extends ViewModel {

    private Logbook logbook;



    public ArrayList<LogEntry> getLogEntries()
    {
        return logbook.getLogEntries();
    }


}
