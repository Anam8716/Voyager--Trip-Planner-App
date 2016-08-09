package com.example;

/**
 * Created by sony on 30-11-2015.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;



/**
 * Created by sony on 28-11-2015.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity4 extends Activity {

    //protected static final String EXTRA_MESSAGE = "com.wingnity.jsonparsingtutorial";

    ArrayList<Actors> actorsList;
    String p,ps="",p1="";
    TripAdapter adapter;
    String source = "";
    String types="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        actorsList = new ArrayList<Actors>();
        Intent mIntent = getIntent();
        p1 = mIntent.getStringExtra("posit2");
        types=mIntent.getStringExtra("types");

        //ps = mIntent.getStringExtra("EXTR");


//        String s="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+p1+"&radius=50000&types="+types+"&key=AIzaSyDwGfWdexnkW2aR7HVtJkHoS6K80pbx3j0";
        String s="https://maps.googleapis.com/maps/api/place/nearbysearch/json?location="+p1+"&radius=200000&types="+types+"&key=AIzaSyB-41IqExoQ_ExBqbui3nl_4R8_uqEAGR8";

        new JSONAsyncTask().execute(s);

        ListView listview = (ListView)findViewById(R.id.list);
        adapter = new TripAdapter(getApplicationContext(), R.layout.row, actorsList);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long id) {

                // TODO Auto-generated method stub
                //arg0.getItemAtPosition(position);

                Toast.makeText(getApplicationContext(), actorsList.get(position).getName(), Toast.LENGTH_LONG).show();
            }
        });
    }

    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {

        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(MainActivity4.this);
            dialog.setMessage("Loading, please wait");
            dialog.setTitle("Connecting server");
            dialog.show();
            dialog.setCancelable(false);
        }

        @Override
        protected Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONObject jsono = new JSONObject(data);
                    JSONArray jarray = jsono.getJSONArray("results");
                    //JSONArray jarray1 = jsono.getJSONArray("airports");
                   // JSONArray jarray2 = jsono.getJSONArray("routes");

                    for (int i = 0; i < jarray.length(); i++) {
                        	JSONObject object = jarray.getJSONObject(i);

                        			Actors actor = new Actors();

                        	actor.setName(object.getString("name"));
                        actor.setDistance(object.getString("rating"));
                        actor.setDuration(object.getString("vicinity"));
                        //	actor.setKind(object.getString("kind"));
                        //		actor.setDescription(object.getString("description"));
                        //actor.setDob(object.getString("dob"));
                        //actor.setCountry(object.getString("country"));
                        //actor.setHeight(object.getString("height"));
                        //actor.setSpouse(object.getString("spouse"));
                        //actor.setChildren(object.getString("children"));
                        //actor.setImage(object.getString("image"));

                        actorsList.add(actor);
                    }

                    //routes
                    	//segments




						/*for(int k=0;k<jarray4.length();k++){
							JSONObject object2 = jarray4.getJSONObject(k);
							JSONArray jarray5 = object2.getJSONArray("itineraries");

							for(int l=0;l<jarray5.length();l++){
								JSONObject object3 = jarray5.getJSONObject(l);
								Actors actor = new Actors();
								actor.setPos(object3.getString("name"));
								actorsList.add(actor);
							}
							Actors actor = new Actors();
							actor.setVehicle(object2.getString("vehicle"));
							actorsList.add(actor);
						}*/

                    //		actor.setDescription(object.getString("description"));
                    //actor.setDob(object.getString("dob"));
                    //actor.setCountry(object.getString("country"));
                    //actor.setHeight(object.getString("height"));
                    //actor.setSpouse(object.getString("spouse"));
                    //actor.setChildren(object.getString("children"));
                    //actor.setImage(object.getString("image"));




                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            dialog.cancel();
            adapter.notifyDataSetChanged();
            if(result == false)
                Toast.makeText(getApplicationContext(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();

        }
    }






}


