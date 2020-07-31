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
import m.yelk11.potalogger.adapters.BookListAdapter;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.ui.viewmodel.BookViewModel;


public class LogbookListFragment extends Fragment {

    private BookViewModel mViewModel;
    private NavController navController;

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


        navController = Navigation.findNavController(view);

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
        final BookListAdapter adapter = new BookListAdapter();

        RecyclerView recyclerView = getView().findViewById(R.id.logbook_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        mViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        mViewModel.getAllLogbooks().observe(getViewLifecycleOwner(), new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> book) {
                Log.d("LOOK", "it happened");
                adapter.submitList(book);
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

                Toast.makeText(getActivity(), "Log deleted", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new BookListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", book.getId());
                navController.navigate(R.id.action_logbookListFragment_to_logEntryListFragment, bundle);
                Toast.makeText(getActivity(), "You clicked something", Toast.LENGTH_SHORT).show();
            }
        });
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


}
