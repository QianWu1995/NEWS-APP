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

    private JSONObject mJSONObject;
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
        asyncDialog = new ProgressDialog(MainActivity.this);
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
                i.putExtra("type","business_insider");
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

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        asyncDialog.dismiss();
    }

    /*private class LongOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            request(params[0]);

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            i.putExtra("obj",mJSONObject.toString());
            asyncDialog.dismiss();

            startActivity(i);
        }

        @Override
        protected void onPreExecute() {


            asyncDialog.setMessage("Loaing");

            asyncDialog.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
    }*/
    /*public JSONObject request(String type){

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(type).build();

        okhttp3.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.d("FAIL","TRUE");

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {

                try {
                    String jsonData = response.body().string();
                    //Response response = call.execute();
                    if (response.isSuccessful()) {

                        try{
                            Log.d("jsonData is",jsonData);

                            mJSONObject = new JSONObject(jsonData);
                            Log.d("JSONOBJ is",mJSONObject.toString()); // mJSONObject is correct.

                        }

                        catch (Exception e){
                            Log.d("exception caught","1");
                        }


                    }
                    else{
                        Log.d("jsonData is","not successful");
                    }
                }
                catch (IOException e) {

                    Log.d("exception caught","2");
                }

            }
        });
        return mJSONObject;
    }*/


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }


}


