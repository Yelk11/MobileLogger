package m.yelk11.potalogger.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import m.yelk11.potalogger.R;
import m.yelk11.potalogger.ui.viewmodel.LogbookVM;

public class NewLogbookFragment extends Fragment {

    private LogbookVM mViewModel;

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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogbookVM.class);
        // TODO: Use the ViewModel
    }
}
