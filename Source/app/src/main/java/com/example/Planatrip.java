package com.example;



import android.app.Activity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.*;
//import android.view.View.OnClickListener;
import android.widget.*;
import android.app.Dialog;
import android.text.InputFilter.LengthFilter;
import android.util.Log;

import com.parse.ParseUser;

public class Planatrip extends Activity implements NumberPicker.OnValueChangeListener {

	TextView srctv,tv,desttv,btv;
	Button plannow;
	Button btn,btn2 ;
	Calendar dateandtime;
	static Dialog d ;
	String destplaceName="....." ;	     /////////
	String placeName="....." ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	setContentView(R.layout.planatrip);
	
	srctv=(TextView) findViewById(R.id.textView2);
	desttv=(TextView) findViewById(R.id.textView4);
	tv=(TextView) findViewById(R.id.textView8);
	btv=(TextView) findViewById(R.id.btv);
	plannow=(Button)findViewById(R.id.plannow);
	dateandtime = Calendar.getInstance(Locale.US);
	btn = (Button) findViewById(R.id.button1);
	btn2 = (Button) findViewById(R.id.button2);
	

    placeName=CustomAutoCompleteTextView.ssource;    
    srctv.setText(placeName);

    
    

    destplaceName=CustomAutoCompleteTextView.sdest;    
    desttv.setText(destplaceName);
    
    
	
	
	btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(final View arg0) {
		
			DatePickerDailog dp = new DatePickerDailog(Planatrip.this,
					dateandtime, new DatePickerDailog.DatePickerListner() {

						@Override
						public void OnDoneButton(Dialog datedialog, Calendar c) {
							datedialog.dismiss();
							dateandtime.set(Calendar.YEAR, c.get(Calendar.YEAR));
							dateandtime.set(Calendar.MONTH,
									c.get(Calendar.MONTH));
							dateandtime.set(Calendar.DAY_OF_MONTH,
									c.get(Calendar.DAY_OF_MONTH));
							((Button)arg0).setText(new SimpleDateFormat("MMMM dd yyyy")
									.format(c.getTime()));
						}

										
						
						
						
						@Override
						public void OnCancelButton(Dialog datedialog) {
							// TODO Auto-generated method stub
							datedialog.dismiss();
						}
					});
			dp.show();
			
			
			
			
		}
	});
	
	
     btn2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(final View arg0) {
		
			DatePickerDailog dp = new DatePickerDailog(Planatrip.this,
					dateandtime, new DatePickerDailog.DatePickerListner() {

						@Override
						public void OnDoneButton(Dialog datedialog, Calendar c) {
							datedialog.dismiss();
							dateandtime.set(Calendar.YEAR, c.get(Calendar.YEAR));
							dateandtime.set(Calendar.MONTH,
									c.get(Calendar.MONTH));
							dateandtime.set(Calendar.DAY_OF_MONTH,
									c.get(Calendar.DAY_OF_MONTH));
							((Button)arg0).setText(new SimpleDateFormat("MMMM dd yyyy")
									.format(c.getTime()));
						}

						@Override
						public void OnCancelButton(Dialog datedialog) {
							// TODO Auto-generated method stub
							datedialog.dismiss();
						}
					});
			dp.show();
			
			
			
			
		}
	});
	
   
     
     
     
	} //eo onCreate
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
/*		//Get the bundle
		Bundle bundle = getIntent().getExtras();

		//Extract the data...
		String stuff = bundle.getString("stuff"); 
		
		srctv.setText(stuff);
		*/
	}
	
	 @Override
	    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

	         Log.i("value is",""+newVal);

	     }

	
	
	public void sourceclick(View v) {
		// TODO Auto-generated method stub
	//	btv.setText("Going Well");        	
		Intent i = new Intent(this,MainActivity.class);
		
		int k=1;
		Bundle bundle = new Bundle();

		//Add your data to bundle
		bundle.putInt("dstuff", k);

		//Add the bundle to the intent
		i.putExtras(bundle);
		
		
		
		startActivity(i);
		
	/**	//Get the bundle
		Bundle bundle = getIntent().getExtras();

		//Extract the data…
		String stuff = bundle.getString("stuff"); 
		
		srctv.setText(stuff);*/
		
	}
	
	public void destclick(View v) {
		// TODO Auto-generated method stub
      //  tv.setText("Going Well");
		
		Intent i = new Intent("android.intent.action.LOCATION");
		int j=2;
		Bundle bundle = new Bundle();

		//Add your data to bundle
		bundle.putInt("dstuff", j);

		//Add the bundle to the intent
		i.putExtras(bundle);
		
		startActivity(i);
		
		
	}
	
	 public void show(View v)
	    {

	         final Dialog d = new Dialog(Planatrip.this);
	         d.setTitle("Pick number of Travellers");
	         d.setContentView(R.layout.dialog);
	         Button b1 = (Button) d.findViewById(R.id.button1);
	         Button b2 = (Button) d.findViewById(R.id.button2);
	         final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
	         np.setMaxValue(20);
	         np.setMinValue(1);
	         np.setWrapSelectorWheel(false);
	         np.setOnValueChangedListener(this);
	         b1.setOnClickListener(new OnClickListener() {
				 @Override
				 public void onClick(View v) {
					 tv.setText(String.valueOf(np.getValue()));
					 d.dismiss();
				 }
			 });
	         b2.setOnClickListener(new OnClickListener() {
				 @Override
				 public void onClick(View v) {
					 d.dismiss();
				 }
			 });
	       d.show();


	    }
	 
	 
	 public void plan(View v) {
			// TODO Auto-generated method stub
	        //btv.setText("Going Well");
		 Intent j=new Intent(Planatrip.this,MainActivity3.class);


		 j.putExtra("source",placeName);
		 j.putExtra("destt", destplaceName);

		 startActivity(j);
			Toast.makeText(getBaseContext(), "Itinerary", Toast.LENGTH_LONG ).show();
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
			startActivity(new Intent(Planatrip.this, DispatchActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	}
	
	

