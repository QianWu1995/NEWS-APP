package com.example.qianwu.cookingrecipe;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.SearchManager;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.TextView;

import com.example.qianwu.cookingrecipe.Model.NewsItem;
import com.example.qianwu.cookingrecipe.Model.Topic;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SearchView mSearchView;
    private ArrayList<NewsItem> newsFeed = new ArrayList<>();
    private Button sportChannel;
    private Button businessChannel;
    private Button trendingChannel;
    private Button techChannel;
    private Button entertainingChannel;
    private Button scienceChannel;


    private ArrayList<Parcelable> mNewsItems;
    private Intent i;
    private ProgressDialog asyncDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mSearchView = (SearchView) findViewById(R.id.content).findViewById(R.id.searchView);
        sportChannel = (Button) findViewById(R.id.content).findViewById(R.id.Sport);
        businessChannel = (Button)  findViewById(R.id.content).findViewById(R.id.Business);
        trendingChannel = (Button) findViewById(R.id.content).findViewById(R.id.Treding);
        techChannel = (Button) findViewById(R.id.content).findViewById(R.id.Tech);
        entertainingChannel = (Button)findViewById(R.id.content).findViewById(R.id.Entertainment);
        scienceChannel = (Button)findViewById(R.id.content).findViewById(R.id.Science);
        sportChannel.setOnClickListener(this);
        businessChannel.setOnClickListener(this);
        trendingChannel.setOnClickListener(this);
        techChannel.setOnClickListener(this);
        entertainingChannel.setOnClickListener(this);
        scienceChannel.setOnClickListener(this);
        mSearchView.setOnSearchClickListener(this);
        mNewsItems = new ArrayList<>();
    }

    @Override
    public void onClick(View view) {

        if (isNetworkAvailable() == false){
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }
        if(view != mSearchView){
            i = new Intent(this, NewsListActivity.class);
            if(view == sportChannel){
                i.putExtra("type","espn");
            }
            if (view == businessChannel){
                i.putExtra("type","business-insider");
            }
            if(view == trendingChannel){
                i.putExtra("type","cnn");
            }
            if(view == techChannel){
                i.putExtra("type","hacker-news");
            }
            if(view == entertainingChannel){
                i.putExtra("type","buzzfeed");
            }
            if(view == scienceChannel){
                i.putExtra("type","new-scientist");
            }

            startActivity(i);
        }
        if(view == mSearchView){
            // search
        }
    }



    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }


}


