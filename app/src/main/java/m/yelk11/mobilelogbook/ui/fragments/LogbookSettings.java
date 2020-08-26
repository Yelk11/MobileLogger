package m.yelk11.mobilelogbook.ui.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import m.yelk11.mobilelogbook.R;

public class LogbookSettings extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.logbook_preferences, rootKey);
    }
}
