/* -------------------------------------------------------------------------------------------------
 * Activity : Detail Activity
 *
 * @author Samone Morris
 * @date   03/13/2018
 * -------------------------------------------------------------------------------------------------
 */
package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private TextView detail_weather;
    private Button return_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detail_weather = (TextView) findViewById( R.id.tv_weather_detail );
        return_button = (Button) findViewById( R.id.button_return );

        // To return to the Main Activity.
        return_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }// end onClick(...)
        });// end OnClickListener(){...}

        // COMPLETED (2) Display the weather forecast that was passed from MainActivity
        Intent intent = getIntent();

        if( intent.hasExtra( Intent.EXTRA_TEXT ) ){
            String details = intent.getStringExtra( Intent.EXTRA_TEXT );

            if( !TextUtils.isEmpty( details ) ){
                detail_weather.setText( details );
            }// end if
        }// end if
    }
}