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
 */
package com.example.android.sunshine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.sunshine.data.SunshinePreferences;
import com.example.android.sunshine.utilities.SunshineDateUtils;
import com.example.android.sunshine.utilities.SunshineWeatherUtils;

public class MainActivity extends AppCompatActivity {

    // COMPLETED(1) Create a field to store the weather display TextView
    private TextView weatherData;
    private String [] dummyData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        // COMPLETED (2) Use findViewById to get a reference to the weather display TextView
        weatherData = (TextView) findViewById( R.id.tv_weather_data );

        // COMPLETED (3) Create an array of Strings that contain fake weather data
        dummyData = new String[] { "Today, May 17 - Clear - 17°C / 15°C",
                                   "Tomorrow - Cloudy - 19°C / 15°C",
                                   "Tues - Rainy- 30°C / 11°C",
                                   "Wed - Thunderstorms - 21°C / 9°C",
                                   "Thu, May 26 - Stormy - 30°C / 11°C",
                                   "Fri, May 27 - Hurricane - 21°C / 9°C",
                                   "Sat, May 28 - Meteors - 16°C / 7°C",
                                   "Sun, May 29 - Apocalypse - 16°C / 8°C"
        };

        // COMPLETED (4) Append each String from the fake weather data array to the TextView
        int i,
            length = dummyData.length;
        for (i = 0; i < length; i++){
            weatherData.append( dummyData[i] + "\n\n" );
        }// end for(...)
    }
}