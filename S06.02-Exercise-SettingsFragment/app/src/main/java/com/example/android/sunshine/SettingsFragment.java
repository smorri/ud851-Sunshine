package com.example.android.sunshine;

/**
 * Settings Fragment
 *
 * @author Samone Morris
 * @date   03/21/2018 - 03/22/2018
 */

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

// COMPLETED (4) Create SettingsFragment and extend PreferenceFragmentCompat

public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener {
    // COMPLETED (10) Implement OnSharedPreferenceChangeListener from SettingsFragment

    // COMPLETED (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference
    private void setPreferenceSummary(Preference preference, Object value){
        // Update the Summary for the Location; We will validate if the input is correct using a
        // OnPreferenceChangeListener later in the code...
        if( preference instanceof EditTextPreference ){
            preference.setSummary( String.valueOf( value ) );
            return;
        }// end if

        // Update the Summary for the Units
        if( preference instanceof ListPreference ){
            ListPreference listPreference = (ListPreference) preference;
            int preferenceIndex = listPreference.findIndexOfValue( String.valueOf( value ) );

            if( preferenceIndex >= 0 ){
                // Set the summary to the label selected from the List
                CharSequence selectedEntry = listPreference.getEntries()[ preferenceIndex ];
                listPreference.setSummary( selectedEntry );
            }// end if
            return;
        }// end else if
    }// end setPreferenceSummary(...)

    // COMPLETED (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource( R.xml.forecast_prefs );

        // COMPLETED (9) Set the preference summary on each preference that isn't a CheckBoxPreference

        // Obtain points to the PreferenceScreen and the SharedPreferences of that screen
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        SharedPreferences sharedPreferences = preferenceScreen.getSharedPreferences();

        // How many preferences are on this Screen?
        int numPreferences = preferenceScreen.getPreferenceCount(),
            i;

        for( i = 0; i < numPreferences; i++){
            Preference preference = preferenceScreen.getPreference( i );
            Object value = sharedPreferences.getString(
                    preference.getKey(),
                    ""
            );

            setPreferenceSummary( preference, value );
        }// end for
    }// end onCreatePreferences(...)

    // COMPLETED (12) Register SettingsFragment (this) as a SharedPreferenceChangedListener in onStart
    @Override
    public void onStart() {
        super.onStart();

        getPreferenceScreen().
                getSharedPreferences().
                registerOnSharedPreferenceChangeListener( this );
    }// end onStart()

    // COMPLETED (13) Unregister SettingsFragment (this) as a SharedPreferenceChangedListener in onStop
    @Override
    public void onStop() {
        getPreferenceScreen().
                getSharedPreferences().
                unregisterOnSharedPreferenceChangeListener( this );

        super.onStop();
    }// end onStop()


    // COMPLETED (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        Preference preference = getPreferenceScreen().findPreference( key );

        if( preference == null ){ return; }

        // We perform the check for non CheckboxPreferences in setPreferenceSummary()
        Object value = sharedPreferences.getString(
                preference.getKey(),
                ""
        );

        setPreferenceSummary( preference, value );
    }// end onSharedPreferenceChanged(...)
}
