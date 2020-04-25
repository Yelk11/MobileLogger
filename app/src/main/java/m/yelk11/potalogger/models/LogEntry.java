package m.yelk11.potalogger.models;


public class LogEntry {
    private String name;

    public LogEntry(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    enum Mode {

    }

    enum Band {
        AM,
        ARDOP,
        ATV,

    }

}
