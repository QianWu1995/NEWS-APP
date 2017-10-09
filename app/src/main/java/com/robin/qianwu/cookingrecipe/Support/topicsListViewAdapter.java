package com.robin.qianwu.cookingrecipe.Support;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.robin.qianwu.cookingrecipe.R;

import java.util.ArrayList;

/**
 * Created by qianwu on 2017-09-18.
 */
public class topicsListViewAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> objects;
    ArrayList<Drawable> objects2;
    public topicsListViewAdapter(Context context, int resource, ArrayList<String> objects,ArrayList<Drawable>  objects2,String query) {
        super(context, resource, objects);
            this.context = context;
            this.objects = objects;
            this.objects2 = objects2;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.elementview, parent, false);
        }
        Log.d("position is",position+"");
        // Lookup view for data population
        ImageView icon = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.thumbnaildescription);
        // Populate the data into the template view using the data object
        if(position <= objects.size()-1) {
            title.setText(objects.get(position));

            icon.setImageDrawable(objects2.get(position));

        }
        return convertView;
    }
}
