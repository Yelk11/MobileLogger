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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;

import m.yelk11.potalogger.models.Logbook;
import m.yelk11.potalogger.ui.activities.MainActivity;
import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.MainLogbookListAdapter;
import m.yelk11.potalogger.ui.viewmodel.LibraryVM;


public class MainFragment extends Fragment implements MainLogbookListAdapter.ItemClickListener {

    private LibraryVM mViewModel;
    private RecyclerView.LayoutManager layoutManager;
    private MainLogbookListAdapter adapter;
    private ArrayList<Logbook> logBookArray;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LibraryVM.class);


        FloatingActionButton fab = getView().findViewById(R.id.new_logbook_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewLogbookFragment newLogbookFragment;
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeView(MainActivity.FragmentEnum.NEW_LOG_BOOK);

            }
        });


        update();
    }

    private void update() {
        updateLogBookArray();
        initRecyclerView();

    }

    private void initRecyclerView()
    {
        RecyclerView recyclerView = getView().findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MainLogbookListAdapter(getActivity(), logBookArray);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void updateLogBookArray() {
        this.logBookArray = mViewModel.getLogBookArray();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position).getLogbookName() + " on row number " + position, Toast.LENGTH_SHORT).show();
    }


    public void save() {

/*
        AdiWriter writer = new AdiWriter();
        writer.append("book name", true);

        Adif3Record record = new Adif3Record();

        for  (LOOP THROUGH ALL RECORDS ) {
            writer.append(record);
        }
        writer.toString(); // -> to some output

        */
    }


    public void loadDefault() {

    }

    public void loadFromFile(File file) {

    }

}
