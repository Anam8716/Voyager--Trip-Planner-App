package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Chandan on 01-12-2015.
 */
public class Place_descrip extends Activity {
     TextView tvdec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.place_descrip);
        tvdec = (TextView) findViewById(R.id.tvdec);

    }
}
