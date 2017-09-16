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
    private ArrayList<Parcelable> mNewsItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        mListView = (ListView) findViewById(R.id.listView);
        header = (TextView)findViewById(R.id.editText);
        mNewsItems = getIntent().getParcelableArrayListExtra("obj");
        header.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test();
            }
        });
    }

    void test(){
        Log.d("ssss",mNewsItems.size()+"");

    }
}
