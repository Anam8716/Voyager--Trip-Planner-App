package com.example;

import com.parse.ParseClassName;
import com.parse.ParseObject;



import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by rufflez on 8/31/14.
 */
@ParseClassName("new")
public class countries extends ParseObject {

   public String getName(){
        return getString("countryName");
    }

    public void setName(String name){
        put("countryName", name);
    }


    /*
    public String getemail(){
        return getString("countryName");
    }

    public void setemail(String email){
        put("countryName", email);
    }
    public int getPhone(){
        return getInt("Phone");
    }

    public void setPhone(int phone){
        put("Phone", phone);
    }*/
    @Override
    public String toString(){
        return  getString("countryName") ;
    }
}
