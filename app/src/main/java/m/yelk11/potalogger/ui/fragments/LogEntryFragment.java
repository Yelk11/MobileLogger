package m.yelk11.potalogger.ui.fragments;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.dbc.Entry;
import m.yelk11.potalogger.ui.viewmodel.EntryVM;
import m.yelk11.potalogger.ui.viewmodel.LogbookVM;

public class LogEntryFragment extends Fragment {

    private EntryVM mViewModel;
    private NavController navController;


    public static LogEntryFragment newInstance() {
        return new LogEntryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_entry_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText date = getView().findViewById(R.id.entry_date);
        EditText time = getView().findViewById(R.id.entry_time);
        EditText frequency = getView().findViewById(R.id.entry_freq);
        EditText mode = getView().findViewById(R.id.entry_mode);
        EditText callsignRx = getView().findViewById(R.id.entry_callsign_rx);
        EditText callsignTx = getView().findViewById(R.id.entry_callsign_tx);
        EditText signalRx = getView().findViewById(R.id.entry_signal_rx);
        EditText signalTx = getView().findViewById(R.id.entry_signal_tx);
        EditText gridsquareRx = getView().findViewById(R.id.entry_gridsquare_rx);
        EditText gridsquareTx = getView().findViewById(R.id.entry_gridsquare_tx);


        navController = Navigation.findNavController(view);

        FloatingActionButton fab = view.findViewById(R.id.log_entry_submitbtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Entry entry = new Entry(0,"LogEntryFragmentLine65",
                        "","","", "","","",
                        "",frequency.getText().toString(),"",
                        gridsquareRx.getText().toString(),"","",
                        mode.getText().toString(),"","",
                        "",date.getText().toString(),signalRx.getText().toString(),
                        "","",signalTx.getText().toString());

                mViewModel.insert(entry);

                navController.navigate(R.id.action_logEntryFragment_to_logEntryListFragment);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EntryVM.class);




    }

}
