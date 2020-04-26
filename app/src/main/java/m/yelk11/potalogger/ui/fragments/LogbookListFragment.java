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

import java.io.File;
import java.util.ArrayList;

import m.yelk11.potalogger.models.Logbook;
import m.yelk11.potalogger.ui.activities.MainActivity;
import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.LogbookListAdapter;
import m.yelk11.potalogger.ui.viewmodel.LogbookVM;


public class LogbookListFragment extends Fragment implements LogbookListAdapter.ItemClickListener {

    private LogbookVM mViewModel;
    private RecyclerView.LayoutManager layoutManager;
    private LogbookListAdapter adapter;
    private ArrayList<Logbook> logBookArray = null;


    public static LogbookListFragment newInstance() {
        return new LogbookListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.logbook_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        NavController navController = Navigation.findNavController(view);

        FloatingActionButton fab = view.findViewById(R.id.new_logbook_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navController.navigate(R.id.action_logbookListFragment_to_newLogbookFragment);

            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogbookVM.class);

        RecyclerView recyclerView = getView().findViewById(R.id.logbook_list);
        TextView textView = getView().findViewById(R.id.emptyLogBookListTextView);

        logBookArray = mViewModel.getLogbookData();

        if (logBookArray == null) {

            textView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            //Toast.makeText(getActivity(), "empty", Toast.LENGTH_SHORT).show();
            textView.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            adapter = new LogbookListAdapter(getActivity(), logBookArray);
            adapter.setClickListener(this);
            recyclerView.setAdapter(adapter);
        }
    }

    private void updateLogBookArray() {
        this.logBookArray = mViewModel.exampleLogbookData();
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
