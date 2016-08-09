package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class start extends Activity {
	EditText ed1,ed2;
	Button b1;
protected void onCreate(Bundle savedInstanceState) {
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main6);
		
		ed1=(EditText) findViewById(R.id.editText1);
		ed2=(EditText) findViewById(R.id.editText2);
		b1=(Button) findViewById(R.id.button1);
	
}
public void next(View v){
	String s1=ed1.getText().toString();
	String s2=ed2.getText().toString();
	Intent i=new Intent(start.this,MainActivity3.class);
	
	i.putExtra("EXTRA_MESS", s2);
	i.putExtra("EXTR", s1);
	startActivity(i);

}
}
