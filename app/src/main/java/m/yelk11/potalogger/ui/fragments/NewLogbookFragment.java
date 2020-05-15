package m.yelk11.potalogger.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.dbc.entity.Logbook;
import m.yelk11.potalogger.ui.viewmodel.LogbookViewModel;

public class NewLogbookFragment extends Fragment {

    private LogbookViewModel mViewModel;

    public static NewLogbookFragment newInstance() {
        return new NewLogbookFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.new_logbook_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button submitBtn = view.findViewById(R.id.submit_new_logbook);
        NavController navController = Navigation.findNavController(view);

        EditText ownerCallsign = getView().findViewById(R.id.new_book_edit_callsign);
        EditText logbookName = getView().findViewById(R.id.new_book_name);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                mViewModel.insertLogbook(new Logbook(logbookName.getText().toString(),ownerCallsign.getText().toString()));

                navController.navigate(R.id.action_newLogbookFragment_to_logEntryListFragment);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogbookViewModel.class);

    }
}
