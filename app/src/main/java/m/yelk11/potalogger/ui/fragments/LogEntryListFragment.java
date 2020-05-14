package m.yelk11.potalogger.ui.fragments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.LogEntryListAdapter;
import m.yelk11.potalogger.adapters.LogbookListAdapter;
import m.yelk11.potalogger.dbc.Entry;
import m.yelk11.potalogger.dbc.Logbook;
import m.yelk11.potalogger.dbc.LogbookWithEntries;
import m.yelk11.potalogger.ui.viewmodel.EntryVM;
import m.yelk11.potalogger.ui.viewmodel.LogbookVM;

public class LogEntryListFragment extends Fragment {

    private EntryVM mViewModel;
    private NavController navController;

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



        navController = Navigation.findNavController(view);

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
        mViewModel = ViewModelProviders.of(this).get(EntryVM.class);


        final LogEntryListAdapter adapter = new LogEntryListAdapter();

        RecyclerView recyclerView = getView().findViewById(R.id.log_entry_list_recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);


        mViewModel.getLogbookEntries().observe(getActivity(), new Observer<List<LogbookWithEntries>>() {
            @Override
            public void onChanged(@Nullable List<LogbookWithEntries> logbookWithEntries) {
                adapter.submitList(logbookWithEntries.get(getArguments().getInt("logbook_id")).entries);
            }
        });


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                mViewModel.delete(adapter.getNoteAt(viewHolder.getAdapterPosition()));

            }
        }).attachToRecyclerView(recyclerView);


        adapter.setOnItemClickListener(new LogEntryListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Entry entries) {


                Toast.makeText(getActivity(), "You clicked something", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
