package m.yelk11.potalogger.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.ui.fragments.LogEntryFragment;
import m.yelk11.potalogger.ui.fragments.LogEntryListFragment;
import m.yelk11.potalogger.ui.fragments.LogbookListFragment;
import m.yelk11.potalogger.ui.viewmodel.LibraryVM;
import m.yelk11.potalogger.ui.fragments.NewLogbookFragment;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, LogbookListFragment.newInstance())
//                    //TODO .addToBackStack("tag")
//                    .commitNow();
//        }

    }










}






