package com.example.qianwu.cookingrecipe;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.qianwu.cookingrecipe.Model.NewsItem;
import com.example.qianwu.cookingrecipe.R;
import com.example.qianwu.cookingrecipe.Support.listViewAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.OkHttpClient;

public class NewsListActivity extends AppCompatActivity {

    private ListView mListView;
    private TextView header;
    private String mNewsItems;
    private String uri1 = "https://newsapi.org/v1/articles?source=";
    private String uri2 = "&sortBy=top&apiKey=e7d800e8ee274c08a764d7fbb71fae77";
    private ProgressDialog asyncDialog;
    private JSONObject mJSONObject;
    private ArrayList<NewsItem> mNewsItemsArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        mListView = (ListView) findViewById(R.id.listView);
        header = (TextView) findViewById(R.id.editText);
        mNewsItems = getIntent().getStringExtra("type");
        header.setText(mNewsItems);
        asyncDialog = new ProgressDialog(NewsListActivity.this);
        mNewsItemsArray = new ArrayList<>();
        new LongOperation().execute(uri1+mNewsItems+uri2);

        listViewAdapter customAdapter = new listViewAdapter(NewsListActivity.this, R.layout.activity_news_list, mNewsItemsArray);

        mListView .setAdapter(customAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i2 = new Intent(NewsListActivity.this, WebviewActivity.class);
                i2.putExtra("url",mNewsItemsArray.get(i).getUrl());
                startActivity(i2);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        asyncDialog.dismiss();
    }



    private class initialzingOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            populateNewsitemArray();
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            asyncDialog.dismiss();
            Log.d("first item",mNewsItemsArray.get(0).getHeading());
        }

        @Override
        protected void onPreExecute() {
            asyncDialog.setMessage("One moment");
            asyncDialog.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
    }


    private class LongOperation extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            request(uri1+mNewsItems+uri2);
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {


            asyncDialog.dismiss();
            new initialzingOperation().execute();
        }

        @Override
        protected void onPreExecute() {


            asyncDialog.setMessage("Loaing");

            asyncDialog.show();
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }

    }
    public void request(String type){

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

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    private void populateNewsitemArray(){
        JSONArray array = null;
        try{
            array = mJSONObject.getJSONArray("articles");
        }
        catch (Exception r){
            Log.d("array","not retrieved");
        }
        try {
            for(int i = 0; i< array.length();++i){
                String Heading, Descrption, author, url, urlToImage, Date, Source;
                Heading = array.getJSONObject(i).getString("title");
                Descrption = array.getJSONObject(i).getString("description");
                author = array.getJSONObject(i).getString("author");
                url = array.getJSONObject(i).getString("url");
                urlToImage = array.getJSONObject(i).getString("urlToImage");
                Date = array.getJSONObject(i).getString("publishedAt");
                Source =  null;

                NewsItem m = new NewsItem(Heading, Descrption, author, url, urlToImage, Date, Source,null);
                mNewsItemsArray.add(m);
            }
        }
        catch (Exception r){
            Log.d("not displaying","2");
        }
    }
}
