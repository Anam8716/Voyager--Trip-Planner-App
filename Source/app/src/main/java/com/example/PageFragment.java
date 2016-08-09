package com.example;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseFile;
import com.parse.ParseImageView;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.example.places;


/**
 * Created by rufflez on 9/2/14.
 */
public class PageFragment extends ListFragment {

    private CustomParseQueryAdapter mAdapter;
    public static final String ARG_PAGE = "ARG_PAGE";
    private String pettype;
    TextView petBreed;
    places pet;
    public static PageFragment create(int page, String type){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putString("type", type);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        pettype = getArguments().getString("type");
        this.setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.page_fragment, container, false);
        mAdapter = new CustomParseQueryAdapter(getActivity());
        setListAdapter(mAdapter);
        mAdapter.loadObjects();
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
    }

    public class CustomParseQueryAdapter extends ParseQueryAdapter<places> {
        public CustomParseQueryAdapter(Context context){
            super(context, new QueryFactory<places>(){
                public ParseQuery create(){
                    ParseQuery query = new ParseQuery("places");
                    query.whereEqualTo("Type", pettype);
                    return query;
                }
            });
        }

        @Override
        public View getItemView(places pet, View v, ViewGroup parent){
            if (v == null){
                v = View.inflate(getContext(), R.layout.pets_with_photo, null);
            }

            super.getItemView(pet, v, parent);

            ParseImageView petImage = (ParseImageView)v.findViewById(R.id.petImage);
            ParseFile imageFile = pet.getPhoto();
            if (imageFile != null){
                petImage.setParseFile(imageFile);
                petImage.loadInBackground();
            }


            TextView petName = (TextView)v.findViewById(R.id.petName);
            petName.setText(pet.getName());
            //TextView petdesc = (TextView)v.findViewById(R.id.desc1);
            //petdesc.setText(pet.getdesc());


            //loadText();

            return v;
        }

    }
}
