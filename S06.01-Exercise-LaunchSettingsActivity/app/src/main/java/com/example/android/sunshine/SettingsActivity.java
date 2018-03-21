package com.example.android.sunshine;

/**-------------------------------------------------------------------------------------------------
 * Settings Activity
 *
 * @author Samone Morris
 * @date   03/21/18
 * -------------------------------------------------------------------------------------------------
 */

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// COMPLETED (1) Add new Activity called SettingsActivity using Android Studio wizard
// COMPLETED (2) Set setDisplayHomeAsUpEnabled to true on the support ActionBar

public class SettingsActivity extends AppCompatActivity {

    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled( true );
    }// end onCreate(...)
}
