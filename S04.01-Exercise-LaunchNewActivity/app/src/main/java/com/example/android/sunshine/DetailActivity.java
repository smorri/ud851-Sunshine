/* -------------------------------------------------------------------------------------------------
 * Activity Class : Detail Activity
 *
 * @author Samone Morris
 * @date   03/12/2018
 * -------------------------------------------------------------------------------------------------
 */

package com.example.android.sunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailActivity extends AppCompatActivity {

    private Button up_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        up_button = (Button) findViewById( R.id.button_up );
        up_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }// end onCreate(...)
}
