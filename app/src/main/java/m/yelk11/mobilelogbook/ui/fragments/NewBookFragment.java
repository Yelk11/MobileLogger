package m.yelk11.mobilelogbook.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import m.yelk11.mobilelogbook.R;
import m.yelk11.mobilelogbook.dbc.entity.Book;
import m.yelk11.mobilelogbook.dbc.entity.Entry;
import m.yelk11.mobilelogbook.ui.viewmodel.NewBookViewModel;

public class NewBookFragment extends Fragment {

    private NewBookViewModel mViewModel;
    private int bookID = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_logbook_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel = new ViewModelProvider(this).get(NewBookViewModel.class);

        TextView textView = getActivity().findViewById(R.id.toolbar_title);
        textView.setText(R.string.new_book_frag_title);


        FloatingActionButton submitBtn = view.findViewById(R.id.submit_new_logbook);
        NavController navController = Navigation.findNavController(view);

        EditText ownerCallsign = getView().findViewById(R.id.new_book_edit_callsign);
        EditText logbookName = getView().findViewById(R.id.new_book_name);

        mViewModel.getLastBook().observe(getActivity(), new Observer<Book>() {
            @Override
            public void onChanged(@Nullable Book book) {
                if (book == null){
                    bookID = 0;
                }else{
                    bookID = book.getId();
                }
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                Book book = new Book(logbookName.getText().toString(), ownerCallsign.getText().toString());
                mViewModel.insert(book);

                Bundle bundle = new Bundle();
                bundle.putInt("logbook_id", bookID);

                navController.navigate(R.id.action_newLogbookFragment_to_logEntryListFragment, bundle);
            }
        });

    }


}
