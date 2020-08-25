package m.yelk11.potalogger.ui.fragments;

import androidx.activity.OnBackPressedCallback;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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

import android.os.Environment;
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

import m.yelk11.potalogger.BuildConfig;
import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.EntryListAdapter;
import m.yelk11.potalogger.dbc.entity.Entry;
import m.yelk11.potalogger.ui.viewmodel.EntryListViewModel;

import static androidx.core.content.FileProvider.getUriForFile;

public class EntryListFragment extends Fragment {

    private EntryListViewModel mViewModel;
    private NavController navController;

    public static EntryListFragment newInstance() {
        return new EntryListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.entry_list_fragment, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);


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
        textView.setText(R.string.EntryListFragmentName);

        navController = Navigation.findNavController(view);

        FloatingActionButton fab = view.findViewById(R.id.log_entry_list_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", getArguments().getInt("logbook_id"));
                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment, bundle);

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EntryListViewModel.class);


        final EntryListAdapter adapter = new EntryListAdapter(getContext());

        RecyclerView recyclerView = getView().findViewById(R.id.log_entry_list_recyclerview);


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
                navController.navigate(R.id.action_logEntryListFragment_to_logEntryFragment, bundle);


                Toast.makeText(getActivity(), "You clicked something", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_share:

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);


                File file = new File(getActivity().getApplication()
                        .getApplicationContext().getFilesDir(), "logbooks/");
                File filePath = new File(file, "other.txt");


                Uri uri = FileProvider.getUriForFile(getActivity().getApplication()
                        .getApplicationContext(),  "m.yelk11.potalogger.provider",
                        filePath);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_STREAM, uri);

                intent.setData(uri);
                startActivity(Intent.createChooser(intent, "Share"));
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
