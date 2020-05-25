package m.yelk11.potalogger.repository;

public class LogbookIdSingleton {
    private static LogbookIdSingleton instance = null;

    public static LogbookIdSingleton getInstance() {
        if (instance == null)
            instance = new LogbookIdSingleton();
        return instance;
    }

    private int logbookId;
    private LogbookIdSingleton(){

    }

    public int getWorkingLogbookId(){
        return logbookId;
    }

    public void setWorkingLogbookId(int logbookId){
        this.logbookId = logbookId;
    }

}
