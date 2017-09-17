package com.example.qianwu.cookingrecipe;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qianwu.cookingrecipe.Model.NewsItem;
import com.example.qianwu.cookingrecipe.R;

import java.util.ArrayList;
import java.util.List;

public class NewsListActivity extends AppCompatActivity {

    private ListView mListView;
    private TextView header;
    private String mNewsItems;
    private String uri1 = "https://newsapi.org/v1/articles?source=";
    private String uri2 = "&sortBy=top&apiKey=e7d800e8ee274c08a764d7fbb71fae77";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        mListView = (ListView) findViewById(R.id.listView);
        header = (TextView) findViewById(R.id.editText);
        mNewsItems = getIntent().getStringExtra("type");
        header.setText(mNewsItems);
    }
}
