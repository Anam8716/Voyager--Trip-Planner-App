package com.example;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;


import java.util.ArrayList;
import java.util.List;


public class MainActivity2 extends FragmentActivity {
    ViewPager pager;
    ArrayList<String> types;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getActionBar().setTitle("Places");

        pager = (ViewPager)findViewById(R.id.pager);
        final ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        types = new ArrayList<String>();

        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Type");
        query.addAscendingOrder("Type");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null){
                    for (ParseObject type : parseObjects){
                        String petType = type.getString("Type");
                        types.add(petType);
                    }
                    pager.setAdapter(adapter);
                }
            }
        });

    }

    private class ViewPagerFragmentAdapter extends FragmentPagerAdapter{
        public ViewPagerFragmentAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            return PageFragment.create(position+1, types.get(position).toString());
        }

        @Override
        public int getCount(){
            return types.size();
        }

        @Override
        public CharSequence getPageTitle(int position){
            return types.get(position).toString();
        }
    }



}
