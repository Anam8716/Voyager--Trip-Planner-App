package com.example;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by rufflez on 7/8/14.
 */
public class SampleApplication extends Application {

    public void onCreate(){
        ParseObject.registerSubclass(places.class);
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_id));
    }
}
