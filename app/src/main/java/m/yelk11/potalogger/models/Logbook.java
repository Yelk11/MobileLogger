package m.yelk11.potalogger.models;


import java.util.ArrayList;

public class Logbook {

    private String logbookName;
    private String callsign;

    private ArrayList<LogEntry> logEntries;

    public Logbook(String logbookName) {
        this.logbookName = logbookName;
        logEntries = new ArrayList<LogEntry>();
    }

    public Logbook(String logbookName, ArrayList<LogEntry> logEntries)
    {
        this.logbookName = logbookName;
        this.logEntries = logEntries;
    }


    //***********************
    //  Getters and Setters
    //***********************

    /**
     * gets the logbooks name
     * @return the name of the logbook
     */
    public String getLogbookName() {
        return logbookName;
    }

    /**
     * Sets the logbooks name
     * @param logbookName
     */
    public void setLogbookName(String logbookName) {
        this.logbookName = logbookName;
    }

    /**
     * gets the callsign of the owner of the logbook
     * @return
     */
    public String getCallsign() {
        return callsign;
    }

    /**
     * sets the owners callsign
     * @param callsign
     */
    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    /**
     * add logbook entry
     * @param logEntry
     */
    public void addEntry(LogEntry logEntry) {
        logEntries.add(logEntry);
    }

    /**
     * gets the logbook entry when provided with the index
     * @param index
     */
    public void getEntry(int index) {
        logEntries.get(index);
    }

    /**
     * gets the list of entries
     * @return ArrayList of logEntries
     */
    public ArrayList<LogEntry> getLogEntries()
    {
        return logEntries;
    }

}
