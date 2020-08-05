package m.yelk11.potalogger.ui.fragments;

import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.adapters.BookListAdapter;
import m.yelk11.potalogger.adif.WriteADIF;
import m.yelk11.potalogger.dbc.entity.Book;
import m.yelk11.potalogger.ui.viewmodel.BookListViewModel;

import static android.content.Context.MODE_PRIVATE;


public class BookListFragment extends Fragment {

    private BookListViewModel mViewModel;
    private NavController navController;

    private File privateRootDir;
    private File adifDir;
    private Uri fileUri;


    public static BookListFragment newInstance() {
        return new BookListFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.book_list_fragment, container, false);
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

        // Set up an Intent to send back to apps that request a file
        Intent resultIntent =
                new Intent("com.example.myapp.ACTION_RETURN_FILE");
        // Get the files/ subdirectory of internal storage
        privateRootDir = getContext().getFilesDir();
        // Get the files/images subdirectory;
        adifDir = new File(privateRootDir, "images");

        // Set the Activity's result to null to begin with
        getActivity().setResult(Activity.RESULT_CANCELED, null);

        final BookListAdapter adapter = new BookListAdapter(getContext());

        RecyclerView recyclerView = getView().findViewById(R.id.logbook_list);


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        mViewModel = ViewModelProviders.of(this).get(BookListViewModel.class);
        mViewModel.getAllLogbooks().observe(getViewLifecycleOwner(), new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> book) {
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
                Book book = adapter.getNoteAt(viewHolder.getAdapterPosition());
                mViewModel.makeFile(book);

            }
        }).attachToRecyclerView(recyclerView);

        adapter.setOnItemClickListener(new BookListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Book book) {
                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", book.getId());
                navController.navigate(R.id.action_logbookListFragment_to_logEntryListFragment, bundle);

            }
        });


    }


}
