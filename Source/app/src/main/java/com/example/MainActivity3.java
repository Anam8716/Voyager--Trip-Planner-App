package com.example;

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
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.Toast;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.ListView;

    import com.parse.ParseUser;

public class MainActivity3 extends Activity {

        //protected static final String EXTRA_MESSAGE = "com.wingnity.jsonparsingtutorial";

        ArrayList<Actors> actorsList;
        String p,ps="";
        ActorAdapter adapter;
        String source = "";
    int j=1;
    String pla= "";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);
            actorsList = new ArrayList<Actors>();

            Intent mIntent = getIntent();
            p = mIntent.getStringExtra("destt");
            source = mIntent.getStringExtra("source");
            ps=p;
            //ps = mIntent.getStringExtra("EXTR");

            String s=		"http://free.rome2rio.com/api/1.2/json/Search?key=p5n00p2u&oName="+source+"&dName=";
            String s1=s+p;
            new JSONAsyncTask().execute(s1);

            ListView listview = (ListView)findViewById(R.id.list);
            adapter = new ActorAdapter(getApplicationContext(), R.layout.row, actorsList);

            listview.setAdapter(adapter);

            listview.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                        long id) {
                    switch(position){

                        case 0:
                            Intent i=new Intent(MainActivity3.this,New.class);

                            i.putExtra("EXTRA_MESSAGE", position);
                            i.putExtra("destination", ps);
                            i.putExtra("source2",source);
                            startActivity(i);

                            break;
                        case 1:
                            Intent j=new Intent(MainActivity3.this,New.class);


                            j.putExtra("destination", ps);
                            j.putExtra("EXTRA_MESSAGE", position);
                            j.putExtra("source2", source);
                            startActivity(j);
                            break;
                        case 2:
                            Intent j1=new Intent(MainActivity3.this,New.class);
                            j1.putExtra("destination", ps);
                            j1.putExtra("source2", source);

                            j1.putExtra("EXTRA_MESSAGE", position);

                            startActivity(j1);
                            break;

                        case 3:
                            Intent j2=new Intent(MainActivity3.this,New.class);
                            j2.putExtra("destination", ps);

                            j2.putExtra("source2", source);
                            j2.putExtra("EXTRA_MESSAGE", position);
                            //		j2.putExtra("EXTRA_ME", p);
                            startActivity(j2);
                            break;

                        case 4:
                            Intent j4=new Intent(MainActivity3.this,New.class);


                            j4.putExtra("destination", ps);
                            j4.putExtra("EXTRA_MESSAGE", position);
                            //	j4.putExtra("EXTRA_ME", p);
                            j4.putExtra("source2", source);
                            startActivity(j4);
                            break;

                        case 5:
                            Intent j5=new Intent(MainActivity3.this,New.class);


                            j5.putExtra("destination", ps);
                            j5.putExtra("EXTRA_MESSAGE", position);
                            //	j5.putExtra("EXTRA_ME", p);
                            j5.putExtra("source2",source);
                            startActivity(j5);
                            break;

                        case 6:
                            Intent j6=new Intent(MainActivity3.this,New.class);


                            j6.putExtra("destination", ps);
                            j6.putExtra("EXTRA_MESSAGE", position);
                            //	j5.putExtra("EXTRA_ME", p);
                            j6.putExtra("source2", source);
                            startActivity(j6);
                            break;

                        case 7:
                            Intent j7=new Intent(MainActivity3.this,New.class);


                            j7.putExtra("destination", ps);
                            j7.putExtra("EXTRA_MESSAGE", position);
                            //	j5.putExtra("EXTRA_ME", p);
                            j7.putExtra("source2",source);
                            startActivity(j7);
                            break;

                        case 8:
                            Intent j8=new Intent(MainActivity3.this,New.class);


                            j8.putExtra("destination", ps);
                            j8.putExtra("EXTRA_MESSAGE", position);
                            //	j5.putExtra("EXTRA_ME", p);
                            j8.putExtra("source2",source);
                            startActivity(j8);
                            break;

                    }
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
                dialog = new ProgressDialog(MainActivity3.this);
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
                        JSONArray jarr = jsono.getJSONArray("places");
                        JSONArray jarray2 = jsono.getJSONArray("routes");
                        JSONObject objec = jarr.getJSONObject(j);
                        Actors act=new Actors();
                        act.setPosition(objec.getString("pos"));
                       pla=objec.getString("pos").toString();

                 //

                        //routes
                        for (int i = 0; i < jarray2.length(); i++) {
                            Actors actor = new Actors();
                            JSONObject object5 = jarray2.getJSONObject(i);
                            JSONObject json = (JSONObject) object5.get("indicativePrice");
                            actor.setPrice(json.getString("price"));


                            //				String object2=object5.getString("indicativePrice");
                            //Actors actor = new Actors();
                            //		 Actors actor = new Actors();
                            actor.setName(object5.getString("name"));
                            actor.setDistance(object5.getString("distance"));
                            actor.setDuration(object5.getString("duration"));
                            //				actor.setChildren(object2.getString("indicativePrice"));
                            actorsList.add(actor);
                        }



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




    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my2, menu);
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
            Intent m=new Intent(MainActivity3.this, MainActivity5.class);
            m.putExtra("posit",pla);
            startActivity(m);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }


