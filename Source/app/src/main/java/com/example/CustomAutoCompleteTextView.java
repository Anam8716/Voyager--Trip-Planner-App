package com.example;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/** Customizing AutoCompleteTextView to return Place Description   
 *  corresponding to the selected item
 */
public class CustomAutoCompleteTextView extends AutoCompleteTextView {
	
     static String ssource="Add Place...";
     static String sdest="Add Destination";
     
	public CustomAutoCompleteTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/** Returns the place description corresponding to the selected item */
	@Override
	protected  CharSequence convertSelectionToString(Object selectedItem) {
		/** Each item in the autocompletetextview suggestion list is a hashmap object */
		HashMap<String, String> hm = ( HashMap <String, String> ) selectedItem;	
		
		/// To Filter Country
		/*String str=(hm.get("description")).toString();
		int index=str.lastIndexOf(',');
		String coun=str.substring(index+1);
		
		return coun;*/
		String str=(hm.get("description")).toString();
/*		Intent i = new Intent ("android.intent.action.PLANATRIP");
		//Create the bundle
		Bundle bundle = new Bundle();

		//Add your data to bundle
		bundle.putString( "stuff" , str);
		//Add the bundle to the intent
		i.putExtras(bundle);

		//Fire that second activity
		startActivity(i); */
        int c=1;
        c=MainActivity.count; // value from main
        
        if(c==1)
		ssource=(hm.get("description")).toString();
		
        else if(c==2)
		sdest=(hm.get("description")).toString();
		
		
		return hm.get("description");	
	}
	
}
