package com.example;



import java.io.IOException;
import java.util.ArrayList;

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
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.parse.ParseUser;

public class New2 extends Activity {
	ArrayList<Actors> actorsList;
	int p,m;
	String dest2;
	String source3="";
	TrainAdapter adapter;
	//private Context context = null;
    
	protected void onCreate(Bundle savedInstanceState) {
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main4);
      actorsList = new ArrayList<Actors>();
  	
  	Intent mIntent = getIntent();
	 p = mIntent.getIntExtra("prev", 0);
	 
	 m = mIntent.getIntExtra("EXTRA", 0);		
      dest2 = mIntent.getStringExtra("dest");
		 source3= mIntent.getStringExtra("source3");
 	 String s=		"http://free.rome2rio.com/api/1.2/json/Search?key=p5n00p2u&oName="+source3+"&dName=";
 	 String s1=s+dest2;
 	 		new JSONAsyncTask().execute(s1);

		
		ListView listview = (ListView)findViewById(R.id.list);
	//	View footerView =  ((LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_layout, null, false);
      //  listview.addFooterView(footerView);
		adapter = new TrainAdapter(getApplicationContext(), R.layout.row3, actorsList);
		
		listview.setAdapter(adapter);

		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
									long id) {

						Intent i=new Intent(New2.this,MainActivity4.class);


						startActivity(i);



				}
			});
		/*		Intent iin=getIntent();
        Bundle bun =iin.getExtras();
		String ss;
		ss =(String) bun.get("EXTRA_MESSAGE");
		p=Integer.parseInt(ss);*/
		
	}
	
	class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {
		
		ProgressDialog dialog;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			dialog = new ProgressDialog(New2.this);
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
					//JSONArray jarray = jsono.getJSONArray("agencies");
				//	JSONArray jarray1 = jsono.getJSONArray("airports");
					JSONArray jarray2 = jsono.getJSONArray("routes");
				
					//for (int i = 0; i < jarray.length(); i++) {
			//			JSONObject object = jarray.getJSONObject(i);
					    	
		//			Actors actor = new Actors();
						
				//		actor.setHeight(object.getString("name"));
					//actor.setSpouse(object.getString("url"));
				//		actor.setDescription(object.getString("description"));
						//actor.setDob(object.getString("dob"));
						//actor.setCountry(object.getString("country"));
						//actor.setHeight(object.getString("height"));
						//actor.setSpouse(object.getString("spouse"));
						//actor.setChildren(object.getString("children"));
						//actor.setImage(object.getString("image"));
						
					//	actorsList.add(actor);
					//}
					
					//routes
				//	for (int i = 0; i < jarray2.length(); i++) {
					
						JSONObject object5 = jarray2.getJSONObject(p);
						
						JSONArray jarray5 = object5.getJSONArray("segments");
						for(int k=0;k<jarray5.length();k++){
							JSONObject object3 = jarray5.getJSONObject(k);
							JSONArray jarray3 = object3.getJSONArray("stops");
							for(int l=0;l<jarray3.length();l++){
								JSONObject object4 = jarray3.getJSONObject(l);
								 Actors actor = new Actors();	
								 actor.setKind(object4.getString("kind"));		
									actor.setsName(object4.getString("name"));
									actorsList.add(actor);
							}
							//JSONObject json=(JSONObject) object3.get("indicativePrice");	
							
							
						}
					//	JSONObject json=(JSONObject) object5.get("indicativePrice");
				//		actor.setPrice(json.getString("price"));
						
						
		//				String object2=object5.getString("indicativePrice");
						 //Actors actor = new Actors();
				//		 Actors actor = new Actors();	
						  /*JSONArray jarray3 = object5.getJSONArray("stops");
						JSONArray jarray4=object5.getJSONArray("segments");
	                       
						//stops
						for(int j=0;j<jarray3.length();j++){
							JSONObject object1 = jarray3.getJSONObject(j);
							
							
					
							actor.setPos(object1.getString("name"));	
							actorsList.add(actor);
							
						}
						//segments
						for(int l=0;l<jarray4.length();l++){
							JSONObject object2 = jarray4.getJSONObject(l);	
							JSONArray jarray5 = object2.getJSONArray("stops");
							
							for(int k=0;k<jarray5.length();k++){
								JSONObject object3 = jarray5.getJSONObject(k);
								
								
								
								actor.setName(object3.getString("name"));	
								actorsList.add(actor);
								
								
							}
							
				
							actor.setVehicle(object2.getString("vehicle"));		
						    
							actorsList.add(actor);
							
						}
                          
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
				//	}						
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
			startActivity(new Intent(New2.this, MainActivity4.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	}

