package m.yelk11.potalogger.ui.fragments;

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
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import m.yelk11.potalogger.R;
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


        LinearLayout llMain = getView().findViewById(R.id.log_entry_linear_layout);


        SharedPreferences sharedPreferences =
                PreferenceManager.getDefaultSharedPreferences(getContext());

        Boolean showGridsquares =
                sharedPreferences.getBoolean("show_gridsquare", false);
        if (showGridsquares) {
            TextView textView = new TextView(getContext());
            EditText editText = new EditText(getContext());
            editText

            editText.setText("I am added dynamically to the view");
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT
            );
            editText.setLayoutParams(params);
            llMain.addView(editText);
        }





    }

}
