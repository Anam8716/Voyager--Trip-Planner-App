package com.example;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseFile;
/**
 * Created by rufflez on 8/31/14.
 */
@ParseClassName("data")
public class data extends ParseObject {

    public String getName() {
        return getString("username");
    }

    public void setName(String name){
        put("username", name);
    }

    public String getpass(){
        return getString("Password");
    }

    public void setpass(String pass){
        put("Password", pass);
    }
    public String getemail(){
        return getString("email");
    }

    public void setemail(String email){
        put("email", email);
    }
    public int getPhone(){
        return getInt("Phone");
    }

    public void setPhone(int phone){
        put("Phone", phone);
    }
    public ParseFile getPhoto(){
        return getParseFile("PetPhoto");
    }

    public void setPhoto(ParseFile photo){
        put("PetPhoto", photo);
    }
    public String getObjectID(){
        return getObjectId();
    }

    public void setObjectID(String objectID){
        put("objectId", objectID);
    }

    public static ParseQuery<data> getQuery(){
        return ParseQuery.getQuery(data.class);
    }


    @Override
    public String toString(){
        return getString("username")  ;
    }
}
