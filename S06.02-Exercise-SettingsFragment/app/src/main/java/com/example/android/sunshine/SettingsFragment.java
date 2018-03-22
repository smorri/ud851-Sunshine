package com.example.android.sunshine;

/**
 * Settings Fragment
 *
 * @author Samone Morris
 * @date   03/21/2018
 */

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

// TODO (4) Create SettingsFragment and extend PreferenceFragmentCompat

public class SettingsFragment extends PreferenceFragmentCompat implements OnSharedPreferenceChangeListener {
    // COMPLETED (10) Implement OnSharedPreferenceChangeListener from SettingsFragment

    // TODO (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference

    // TODO (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

    }// end onCreatePreferences(...)

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

    }
}
