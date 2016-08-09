package com.example;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseFile;
/**
 * Created by rufflez on 8/31/14.
 */
@ParseClassName("places")
public class places extends ParseObject {

    public String getName() {
        return getString("Name");
    }

    public void setName(String name){
        put("Name", name);
    }

   /* public String getpass(){
        return getString("Password");
    }

    public void setpass(String pass){
        put("Password", pass);
    }*/
    public String getdesc(){
        return getString("Description");
    }

    public void setdesc(String email){
        put("Description", email);
    }


   public int getType(){
       return getInt("Type");
   }

    public void setType(int type) {
        put("Type", type);
    }
    public ParseFile getPhoto(){
        return getParseFile("images");
    }

    public void setPhoto(ParseFile photo){
        put("images", photo);
    }
    public String getObjectID(){
        return getObjectId();
    }

    public void setObjectID(String objectID){
        put("objectId", objectID);
    }

    public static ParseQuery<places> getQuery(){
        return ParseQuery.getQuery(places.class);
    }



}

