package m.yelk11.potalogger.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.ui.fragments.LogEntryFragment;
import m.yelk11.potalogger.ui.fragments.LogEntryListFragment;
import m.yelk11.potalogger.ui.fragments.MainFragment;
import m.yelk11.potalogger.ui.viewmodel.LibraryVM;
import m.yelk11.potalogger.ui.fragments.NewLogbookFragment;


public class MainActivity extends AppCompatActivity {

    private LibraryVM mainViewModel;
    public static String NEW_LOG_BOOK = "NEW_LOG_BOOK";

    public enum FragmentEnum{
        NEW_LOG_BOOK,
        LOG_ENTRY,
        LOG_ENTRY_LIST,
        MAIN
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    //TODO .addToBackStack("tag")
                    .commitNow();
        }

    }



    public void changeView(FragmentEnum viewName)
    {
        setContentView(R.layout.main_activity);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (viewName)
        {
            case NEW_LOG_BOOK:
                ft.add(R.id.container, new NewLogbookFragment()).addToBackStack("NEW_LOG_BOOK");
            case LOG_ENTRY:
                ft.add(R.id.container, new LogEntryFragment()).addToBackStack("LOG_ENTRY");
            case LOG_ENTRY_LIST:
                ft.add(R.id.container, new LogEntryListFragment()).addToBackStack("LOG_ENTRY_LIST");
            case MAIN:
                ft.add(R.id.container, new MainFragment()).addToBackStack("MAIN");
            default:
                ft.add(R.id.container, new MainFragment()).addToBackStack("MAIN");
        }
        ft.commit();
    }






}






