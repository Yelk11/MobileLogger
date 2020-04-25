package m.yelk11.potalogger.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import m.yelk11.potalogger.models.LogEntry;
import m.yelk11.potalogger.models.Logbook;

public class LogbookVM extends ViewModel {

    private Logbook logbook;



    public ArrayList<LogEntry> getLogEntries()
    {
        return exampleData();
    }



    public ArrayList<LogEntry> exampleData()
    {
        ArrayList<LogEntry> logEntries = new ArrayList<>();
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        logEntries.add(new LogEntry("test"));
        return logEntries;
    }

}
