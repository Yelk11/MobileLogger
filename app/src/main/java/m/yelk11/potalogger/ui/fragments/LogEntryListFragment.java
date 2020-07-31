package m.yelk11.potalogger.ui.fragments;

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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.EntryListAdapter;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.ui.viewmodel.BookViewModel;

public class LogEntryListFragment extends Fragment {

    private BookViewModel mViewModel;
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

                Log.d("LOOK", "Logbook id: " + Integer.toString(getArguments().getInt("logbook_id")));

                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", getArguments().getInt("logbook_id"));
                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment, bundle);

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(BookViewModel.class);


        final EntryListAdapter adapter = new EntryListAdapter();

        RecyclerView recyclerView = getView().findViewById(R.id.log_entry_list_recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);




        mViewModel.findEntriesForLogbook(getArguments().getInt("logbook_id")).observe(getActivity(), new Observer<List<Entry>>() {
            @Override
            public void onChanged(@Nullable List<Entry> entries) {
                adapter.submitList(entries);
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


        adapter.setOnItemClickListener(new EntryListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Entry entries) {

                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", getArguments().getInt("logbook_id"));
                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment, bundle);


                Toast.makeText(getActivity(), "You clicked something", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
