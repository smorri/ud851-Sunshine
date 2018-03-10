package com.example.android.sunshine;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Samone on 3/10/2018.
 */

// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
// COMPLETED (15) Add a class file called ForecastAdapter
// COMPLETED (22) Extend RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>

public class ForecaseAdapter extends RecyclerView.Adapter<ForecaseAdapter.ForecaseAdapterViewholder> {
    // COMPLETED (23) Create a private string array called mWeatherData
    private String[] mWeatherData;

    // COMPLETED (47) Create the default constructor (we will pass in parameters in a later lesson)
    public ForecaseAdapter(){

    }// end constructor ForecastAdapter()

    @Override
    public ForecaseAdapterViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ForecaseAdapterViewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
    // COMPLETED (16) Create a class within ForecastAdapter called ForecastAdapterViewHolder
    // COMPLETED (17) Extend RecyclerView.ViewHolder
    class ForecaseAdapterViewholder extends RecyclerView.ViewHolder{

        // COMPLETED (18) Create a public final TextView variable called mWeatherTextView
        public final TextView mWeatherTextView;

        // COMPLETED (19) Create a constructor for this class that accepts a View as a parameter
        // COMPLETED (20) Call super(view) within the constructor for ForecastAdapterViewHolder
        // COMPLETED (21) Using view.findViewById, get a reference to this layout's TextView and save it to mWeatherTextView

        public ForecaseAdapterViewholder(View itemView) {
            super( itemView );
            mWeatherTextView = (TextView) itemView.findViewById( R.id.tv_weather_data );
        }// end ForecaseAdapterViewholder(...)

    }// end class ForecaseAdapterViewholder
    // Within ForecastAdapterViewHolder ///////////////////////////////////////////////////////////
}
// Within ForecastAdapter.java /////////////////////////////////////////////////////////////////
