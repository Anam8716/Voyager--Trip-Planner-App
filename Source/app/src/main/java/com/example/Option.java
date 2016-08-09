package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.parse.ParseUser;

public class Option extends Activity{
Button b1,b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.option);
	b1=(Button)findViewById(R.id.button1);

		b2=(Button)findViewById(R.id.button2);
	}
	public void pat(View v){
		Intent i=new Intent(this,Planatrip.class);
		startActivity(i);

	}
	public void dp(View v){
		Intent i=new Intent(this,MainActivity2.class);
		startActivity(i);

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
			startActivity(new Intent(Option.this, DispatchActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
