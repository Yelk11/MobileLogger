package m.yelk11.mobilelogbook.ui.fragments;

import androidx.lifecycle.ViewModelProviders;

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
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import m.yelk11.mobilelogbook.R;
import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.ui.viewmodel.NewEntryViewModel;

public class NewEntryFragment extends Fragment {

    private NewEntryViewModel mViewModel;
    private NavController navController;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_entry_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = getActivity().findViewById(R.id.toolbar_title);
        textView.setText(R.string.new_entry_frag_title);


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
                Entry entry = new Entry();
                entry.setLogbookId(getArguments().getInt("logbook_id"));
                entry.setmDate(date.getText().toString());
                entry.setmTime(time.getText().toString());
                entry.setmFrequency(frequency.getText().toString());
                entry.setmMode(mode.getText().toString());
                entry.setmCallsignRx(callsignRx.getText().toString());
                entry.setmCallsignTx(callsignTx.getText().toString());
                entry.setmSignalReportRx(signalRx.getText().toString());
                entry.setmSignalReportTx(signalTx.getText().toString());
                entry.setmGridsquareRx(gridsquareRx.getText().toString());
                entry.setmGridsquareTx(gridsquareTx.getText().toString());


                mViewModel.insert(entry);

                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", getArguments().getInt("logbook_id"));
                navController.navigate(R.id.action_logEntryFragment_to_logEntryListFragment, bundle);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(NewEntryViewModel.class);
    }

}
