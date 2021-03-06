package m.yelk11.mobilelogbook.ui.fragments;

import androidx.activity.OnBackPressedCallback;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.List;

import m.yelk11.mobilelogbook.BuildConfig;
import m.yelk11.mobilelogbook.R;
import m.yelk11.mobilelogbook.adapters.EntryListAdapter;
import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.ui.viewmodel.EntryListViewModel;

public class EntryListFragment extends Fragment {

    private EntryListViewModel mViewModel;
    private NavController navController;

    public static EntryListFragment newInstance() {
        return new EntryListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);


        return inflater.inflate(R.layout.entry_list_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                navController.navigate(R.id.action_logEntryListFragment_to_logbookListFragment);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView = getActivity().findViewById(R.id.toolbar_title);
        textView.setText(R.string.entry_list_frag_title);

        navController = Navigation.findNavController(view);


        FloatingActionButton fab = view.findViewById(R.id.log_entry_list_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", getArguments().getInt("logbook_id"));
                bundle.putInt("entry_id", -1);
                Log.d("ENTRY_ID", "Entry List: " + -1);
                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment, bundle);

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(EntryListViewModel.class);


        final EntryListAdapter adapter = new EntryListAdapter(getContext());

        RecyclerView recyclerView = getView().findViewById(R.id.log_entry_list_recyclerview);

        Log.d("BOOK_ID", "Entry List with Book Id: " + getArguments().getInt("logbook_id"));

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);



        mViewModel.getAllBookEntries(getArguments().getInt("logbook_id")).observe(getActivity(), new Observer<List<Entry>>() {
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
                bundle.putInt("entry_id", entries.getId());
                Log.d("ENTRY_ID", "Entry List: " + entries.getId());
                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment, bundle);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_share:



                // Share the logbook
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


                File file = new File(getActivity().getApplication()
                        .getApplicationContext().getFilesDir(), "logbooks/");
                File filePath = new File(file, "other.txt");


                Uri uri = FileProvider.getUriForFile(getActivity().getApplication()
                        .getApplicationContext(),  BuildConfig.APPLICATION_ID +".provider",
                        filePath);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_STREAM, uri);

                intent.setData(uri);
                startActivity(Intent.createChooser(intent, getString(R.string.chooser_title)));
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.booklist_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}
