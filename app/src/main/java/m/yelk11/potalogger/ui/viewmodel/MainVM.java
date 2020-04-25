package m.yelk11.potalogger.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import m.yelk11.potalogger.models.Logbook;

public class  MainVM extends ViewModel {


    private ArrayList<Logbook> logbooks;

    public MainVM()
    {
        addDefaultData();
    }




    public ArrayList<Logbook> getLogBookArray()
    {
        return logbooks;
    }

    private void addDefaultData(){
        logbooks = new ArrayList<>();
        logbooks.add(new Logbook("One"));
        logbooks.add(new Logbook("Two"));
        logbooks.add(new Logbook("Three"));
    }
}
