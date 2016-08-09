package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by sony on 01-12-2015.
 */
public class MainActivity5 extends Activity {
String a="";
    String b="";
    ArrayList<Actors> actorsList;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
        //ActorAdapter adapter;
        //actorsList = new ArrayList<Actors>();
        ListView listview = (ListView) findViewById(R.id.list);
        Intent mIntent = getIntent();
        b= mIntent.getStringExtra("posit");
        String[] values=new String[]{
                "Places To worship",
                "Shopping Mall",
                "Restaurant",
                "airport",
                "Station"

        };
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,values);
 //       adapter = new ActorAdapter(getApplicationContext(), R.layout.row, actorsList);

        listview.setAdapter(adapter2);
        //actorsList.get("").toString();
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {
switch (position) {

    case 0:
    Intent m = new Intent(MainActivity5.this, MainActivity4.class);
        a="place_of_worship";
    m.putExtra("types", a);
        m.putExtra("posit2", b);
    startActivity(m);
        break;
    case 1:
        Intent m1 = new Intent(MainActivity5.this, MainActivity4.class);
        a="shopping_mall";
        m1.putExtra("types", a);
        m1.putExtra("posit2", b);
        startActivity(m1);
        break;
    case 2:
        Intent m2 = new Intent(MainActivity5.this, MainActivity4.class);
        a="food";
        m2.putExtra("types", a);
        m2.putExtra("posit2", b);
        startActivity(m2);
        break;
    case 3:
        Intent m3 = new Intent(MainActivity5.this, MainActivity4.class);
        a="airport";
        m3.putExtra("types", a);
        m3.putExtra("posit2", b);
        startActivity(m3);
        break;
    case 4:
        Intent m4 = new Intent(MainActivity5.this, MainActivity4.class);
        a="shopping_mall";
        m4.putExtra("types", a);

        startActivity(m4);
        break;
    case 5:
        Intent m5 = new Intent(MainActivity5.this, MainActivity4.class);
        a="amusement_park";
        m5.putExtra("types", a);

        startActivity(m5);
        break;
}
            }
        });
    }
}