/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Samone Morris
 * @date   03/07/2018
 */
package com.example.android.sunshine;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.android.sunshine.data.SunshinePreferences;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        /*
         * Using findViewById, we get a reference to our TextView from xml. This allows us to
         * do things like set the text of the TextView.
         */
        mWeatherTextView = (TextView) findViewById(R.id.tv_weather_data);

        // COMPLETED (4) Delete the dummy weather data. You will be getting REAL data from the Internet in this lesson.

        // COMPLETED (3) Delete the for loop that populates the TextView with dummy data

        // COMPLETED (9) Call loadWeatherData to perform the network request to get the weather
        loadWeatherData();
    }

    // COMPLETED (8) Create a method that will get the user's preferred location and execute your new AsyncTask and call it loadWeatherData
    private void loadWeatherData(){
        FetchWeatherTask asyncTask = new FetchWeatherTask();
        String location = SunshinePreferences.getPreferredWeatherLocation( this );

        asyncTask.execute( NetworkUtils.buildUrl( location ) );
    }// end loadWeatherData()

    private void updateUI(final String data){
        mWeatherTextView.setText( data );
    }// end updateUI

    // COMPLETED (5) Create a class that extends AsyncTask to perform network requests
    // COMPLETED (6) Override the doInBackground method to perform your network requests
    // COMPLETED (7) Override the onPostExecute method to display the results of the network request
    private class FetchWeatherTask extends AsyncTask<URL, Void, String>{
        @Override
        protected String doInBackground(URL... urls) {
            String jsonResponse = null;

            // If there are no URLs to parse or if the first URL object is null, then return a null
            // JSON Response
            if( urls.length < 1 || urls[0] == null ){
                return jsonResponse;
            }// end if

            // Retrieve and parse the JSON Response
            StringBuilder result = new StringBuilder();

            try {
                jsonResponse = NetworkUtils.getResponseFromHttpUrl( urls[0] );

                if( jsonResponse == null ){
                    return jsonResponse;
                }// end if

                String [] data =
                        OpenWeatherJsonUtils.getSimpleWeatherStringsFromJson(
                                MainActivity.this,
                                 jsonResponse
                );

                for( String item : data ){
                    result.append( item ).append("\n\n");
                }// end for
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } // end try / catch


            return result.toString();
        }// end doInBackground(...)

        @Override
        protected void onPostExecute(String s) {
            if( !TextUtils.isEmpty( s ) ){ updateUI( s ); }
        }// end onPostExecute()
    }// end class WeatherAsyncTask
}