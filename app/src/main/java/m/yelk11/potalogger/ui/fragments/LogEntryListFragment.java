package m.yelk11.potalogger.ui.fragments;

import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

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
        return inflater.inflate(R.layout.log_entry_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        NavController navController = Navigation.findNavController(view);

        FloatingActionButton fab = view.findViewById(R.id.log_entry_list_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment);

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogbookVM.class);


        logEntry = null;//mViewModel.getLogEntries();


        RecyclerView recyclerView = getView().findViewById(R.id.log_entry_list_recyclerview);
        TextView textView = getView().findViewById(R.id.emptyTextView);


        if (logEntry == null)
        {
            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }else{
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new LogEntryListAdapter(getActivity(), logEntry);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }
    }




    private void updateLogBookArray(ArrayList<LogEntry> logEntries) {
        this.logEntry = logEntries;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position).getName() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}
