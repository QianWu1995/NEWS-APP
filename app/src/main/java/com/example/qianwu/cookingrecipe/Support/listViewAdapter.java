package com.example.qianwu.cookingrecipe.Support;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qianwu.cookingrecipe.Model.NewsItem;
import com.example.qianwu.cookingrecipe.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qianwu on 2017-09-17.
 */
public class listViewAdapter extends ArrayAdapter<NewsItem>{
    Context context;
    public listViewAdapter(Context context, int resource, ArrayList<NewsItem> objects) {
        super(context, resource, objects);
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        NewsItem currentItem = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }
        // Lookup view for data population
        ImageView icon = (ImageView) convertView.findViewById(R.id.leftIco);
        TextView title = (TextView) convertView.findViewById(R.id.heading);
        TextView descp = (TextView) convertView.findViewById(R.id.desc);
        // Populate the data into the template view using the data object
        title.setText(currentItem.getHeading());
        descp.setText(currentItem.getDescrption());
        Picasso.with(this.context).load(currentItem.getUrlToImage()).into(icon);
        return convertView;
    }
}
