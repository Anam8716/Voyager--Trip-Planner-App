package com.example;

import android.app.ExpandableListActivity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by rufflez on 8/31/14.
 */
public class ParseListActivity extends ListActivity {

    List<places> pets = new ArrayList<places>();
    ScrollView sv;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parse_list);
        ParseQuery<places> query = new ParseQuery<places>("places");
        query.findInBackground(new FindCallback<places>() {
            @Override
            public void done(List<places> list, ParseException e) {
                if (e != null) {


                    Toast.makeText(ParseListActivity.this, "Error " + e, Toast.LENGTH_SHORT).show();
                }
                for (places pet : list) {
                    places newPet = new places();
                    newPet.setName(pet.getName());

                    newPet.setdesc(pet.getdesc());

                    pets.add(newPet);
                }

                ArrayAdapter<places> adapter = new ArrayAdapter<places>(ParseListActivity.this, android.R.layout.simple_list_item_1, pets);
                setListAdapter(adapter);


            }
        });




    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            ParseUser.getCurrentUser().logOut();
            startActivity(new Intent(this, DispatchActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent in  = new Intent(this,Place_descrip.class);
        startActivity(in);

    }*/



}

