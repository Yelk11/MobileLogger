package m.yelk11.potalogger.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import m.yelk11.potalogger.models.LogEntry;
import m.yelk11.potalogger.models.Logbook;

public class LogbookVM extends ViewModel {

    private Logbook logbook;



    public ArrayList<LogEntry> getLogEntries()
    {
        return exampleLogEntryData();
    }

    public ArrayList<Logbook> getLogbookData()
    {
        return exampleLogbookData();
    }

    public ArrayList<LogEntry> exampleLogEntryData()
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

    public ArrayList<Logbook> exampleLogbookData()
    {
        ArrayList<Logbook> logbooks = new ArrayList<>();
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        logbooks.add(new Logbook("test"));
        return logbooks;
    }

}
