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

	public class TrainAdapter extends ArrayAdapter<Actors> {
		ArrayList<Actors> actorList;
		LayoutInflater vi;
		int Resource;
		ViewHolder holder;

		public TrainAdapter(Context context, int resource, ArrayList<Actors> objects) {
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
				holder.imageview = (ImageView) v.findViewById(R.id.imageView1);
				holder.tvName = (TextView) v.findViewById(R.id.textView1);
				holder.tvDescription = (TextView) v.findViewById(R.id.tvstation);
			//	holder.tvSpouse=(TextView)v.findViewById(R.id.termination);
		//		holder.tname=(TextView) v.findViewById(R.id.textView2);
			//	holder.tvDOB = (TextView) v.findViewById(R.id.tvprice1);
				v.setTag(holder);
			} else {
				holder = (ViewHolder) v.getTag();
			}
			holder.imageview.setImageResource(R.drawable.abc_btn_radio_to_on_mtrl_015);
			//new DownloadImageTask(holder.imageview).execute(actorList.get(position).getImage());
			holder.tvName.setText(actorList.get(position).getKind());
			holder.tvDescription.setText(actorList.get(position).getsName());
			//holder.tname.setText(actorList.get(position).gettName());
			//holder.tvName.setText(actorList.get(position).getHeight());
			//holder.tvName.setText(actorList.get(position).getSpouse());
		//	holder.tvDOB.setText(actorList.get(position).getPrice());
			//holder.tvCountry.setText("Price:"+Integer.parseInt(actorList.get(position).getPrice())*66+"Rs");
		//	holder.tvHeight.setText("Height: " + actorList.get(position).getChildren());
			//holder.tvSpouse.setText("Term: " + actorList.get(position).getsName());
		//	holder.tvChildren.setText("Children: " + actorList.get(position).getVehicle());
			return v;

		}

		static class ViewHolder {
			public ImageView imageview;
			public TextView tvName;
			public TextView tvDescription;
			public TextView tvDOB;
			public TextView tvCountry;
			public TextView tvHeight;
			public TextView tvSpouse;
			public TextView tvChildren;
			//public TextView tname;

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

