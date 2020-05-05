package m.yelk11.potalogger.ui.fragments;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.models.LogEntryType;
import m.yelk11.potalogger.ui.viewmodel.LogbookVM;

public class LogEntryFragment extends Fragment {

    private LogbookVM mViewModel;

    private String[] entryTypes ={
            "power_tx_rx",
            "grid_squares",

    };

    public static LogEntryFragment newInstance() {
        return new LogEntryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_entry_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogbookVM.class);


        LinearLayout linearLayout = getView().findViewById(R.id.log_entry_linear_layout);


        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getContext());


        LinearLayout.LayoutParams singleParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        LinearLayout.LayoutParams doubleParam = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        doubleParam.setLayoutDirection(LinearLayout.LAYOUT_DIRECTION_LTR);


        // Date and Time
        Boolean dateAndTime =
                sharedPreferences.getBoolean("show_date_time", false);
        if (true) {
            TextView title = new TextView(getContext());
            EditText timeAndDate = new EditText(getContext());
            title.setText("Time and Date");
            timeAndDate.setText("Enter Date Here");




            linearLayout.addView(title);
            linearLayout.addView(timeAndDate);
        }
        //frequency

        // Callsigns

        //power report
        Boolean powerReport =
                sharedPreferences.getBoolean("power_report", false);
        if (true) {
            TextView title = new TextView(getContext());
            EditText powerTx = new EditText(getContext());
            EditText PowerRx = new EditText(getContext());
            title.setText("Time and Date");
            powerTx.setText("Enter Date Here");
            PowerRx.setText("Enter Date Here");

            powerTx.setLayoutParams(doubleParam);
            PowerRx.setLayoutParams(doubleParam);

            linearLayout.addView(title);
            linearLayout.addView(powerTx);
            linearLayout.addView(PowerRx);
        }
        // signal report

        //grid square

        //comments












//        Boolean showGridsquares =
//                sharedPreferences.getBoolean("show_gridsquare", false);
//        if (showGridsquares) {
//            TextView textView = new TextView(getContext());
//            EditText editText = new EditText(getContext());
//
//
//            editText.setText("I am added dynamically to the view");
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    LinearLayout.LayoutParams.MATCH_PARENT,
//                    LinearLayout.LayoutParams.MATCH_PARENT
//            );
//            editText.setLayoutParams(params);
//            linearLayout.addView(editText);
//        }






    }

}
