package m.yelk11.potalogger.ui.fragments;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import m.yelk11.potalogger.models.LogEntry;
import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.LogEntryListAdapter;
import m.yelk11.potalogger.ui.viewmodel.LogbookVM;

public class LogEntryListFragment extends Fragment implements LogEntryListAdapter.ItemClickListener {

    private LogbookVM mViewModel;
    private LogEntryListAdapter adapter;
    private ArrayList<LogEntry> logEntry;

    public static LogEntryListFragment newInstance() {
        return new LogEntryListFragment();
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


        logEntry = mViewModel.getLogEntries();


        RecyclerView recyclerView = getView().findViewById(R.id.log_entry_list_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter = new LogEntryListAdapter(getActivity(), logEntry);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);
    }




    private void updateLogBookArray(ArrayList<LogEntry> logEntries) {
        this.logEntry = logEntries;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position).getName() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
