package com.example;

import java.io.InputStream;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ActorAdapter extends ArrayAdapter<Actors> {
	ArrayList<Actors> actorList;
	LayoutInflater vi;
	int Resource;
	ViewHolder holder;
	String dest="";

	public ActorAdapter(Context context, int resource, ArrayList<Actors> objects) {
		super(context, resource, objects);
		vi = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Resource = resource;
		actorList = objects;
	}
 
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// convert view = design
		View v = convertView;
		if (v == null) {
			holder = new ViewHolder();
			v = vi.inflate(Resource, null);
			holder.imageview = (ImageView) v.findViewById(R.id.ivImage);
			holder.tvName = (TextView) v.findViewById(R.id.tvName);
			holder.tvDescription = (TextView) v.findViewById(R.id.tvDescriptionn);
			holder.tvDOB = (TextView) v.findViewById(R.id.tvDateOfBirth);
			holder.tvCountry = (TextView) v.findViewById(R.id.tvCountry);
//		holder.tvpos = (TextView) v.findViewById(R.id.textView9);
			//holder.tvSpouse = (TextView) v.findViewById(R.id.tvSpouse);
		//	holder.tvChildren = (TextView) v.findViewById(R.id.tvChildren);
			v.setTag(holder);
		} else {
			holder = (ViewHolder) v.getTag();
		}



			  //on every row call


		//new DownloadImageTask(holder.imageview).execute(actorList.get(position).getImage());
		holder.tvName.setText(actorList.get(position).getName());
		holder.tvDescription.setText("Distance: "+ actorList.get(position).getDistance()+" Km");
		
		holder.tvDOB.setText("Duration: " + Integer.parseInt(actorList.get(position).getDuration())/60+"Hours  "+Integer.parseInt(actorList.get(position).getDuration())%60+"Min");
		holder.tvCountry.setText("Price: "+"Rs. "+Integer.parseInt(actorList.get(position).getPrice())*65);
//		holder.tvpos.setText(actorList.get(position).getPos());
		//holder.tvSpouse.setText("Spouse: " + actorList.get(position).getName());
	//	holder.tvChildren.setText("Children: " + actorList.get(position).getVehicle());
		if(holder.tvName.getText().equals("Train")){
			holder.imageview.setImageResource(R.drawable.train);
		}
		else if(holder.tvName.getText().equals("Taxi")) {
			holder.imageview.setImageResource(R.drawable.taxi);
		}

		else if(holder.tvName.getText().equals("Drive")) {
			holder.imageview.setImageResource(R.drawable.car);
		}
		else if(holder.tvName.getText().equals("Bus")) {
			holder.imageview.setImageResource(R.drawable.bus);
		}
		else if(holder.tvName.getText().equals("Rideshare")) {
			holder.imageview.setImageResource(R.drawable.car);
		}
		else
			holder.imageview.setImageResource(R.drawable.flight);
		return v;

	}

	static class ViewHolder {
		public ImageView imageview;
		public TextView tvName;
		public TextView tvDescription;
		public TextView tvDOB;
		public TextView tvCountry;
		public TextView tvpos;
		public TextView tvSpouse;
		public TextView tvChildren;


	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;

		public DownloadImageTask(ImageView bmImage) {
			this.bmImage = bmImage;
		}

		protected Bitmap doInBackground(String... urls) {
			String urldisplay = urls[0];
			Bitmap mIcon11 = null;
			try {
				InputStream in = new java.net.URL(urldisplay).openStream();
				mIcon11 = BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				Log.e("Error", e.getMessage());
				e.printStackTrace();
			}
			return mIcon11;
		}

		protected void onPostExecute(Bitmap result) {
			bmImage.setImageBitmap(result);
		}

	}
}