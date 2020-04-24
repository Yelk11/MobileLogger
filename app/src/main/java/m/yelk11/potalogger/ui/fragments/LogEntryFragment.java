package m.yelk11.potalogger.ui.fragments;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import m.yelk11.potalogger.R;

public class LogEntryFragment extends Fragment {

    private LogEntryVM mViewModel;

    public static LogEntryFragment newInstance() {
        return new LogEntryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.log_entry_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LogEntryVM.class);


        LinearLayout llMain = getView().findViewById(R.id.log_entry_linear_layout);
        TextView textView = new TextView(getContext());
        textView.setText("I am added dynamically to the view");
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        textView.setLayoutParams(params);
        llMain.addView(textView);





    }

}
