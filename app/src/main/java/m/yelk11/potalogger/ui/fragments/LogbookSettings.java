package m.yelk11.potalogger.ui.fragments;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceFragmentCompat;

import m.yelk11.potalogger.R;

public class LogbookSettings extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.logbook_preferences, rootKey);
    }
}
