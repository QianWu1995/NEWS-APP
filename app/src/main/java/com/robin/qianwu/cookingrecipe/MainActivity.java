package com.robin.qianwu.cookingrecipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.robin.qianwu.cookingrecipe.Model.NewsProvider;
import com.robin.qianwu.cookingrecipe.Support.topicsListViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;
    private NewsProvider mProvider;
    private topicsListViewAdapter mTopicsListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mProvider = new NewsProvider(MainActivity.this);
        mTopicsListViewAdapter = new topicsListViewAdapter(MainActivity.this,R.layout.activity_main,mProvider.getNames(),mProvider.getLogos(),"");
        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView = (ListView)findViewById(R.id.listView2);
        mListView.setAdapter(mTopicsListViewAdapter);

        final ArrayList<String> backUpNames = mProvider.getNames();
        final ArrayList<Drawable> backUpDrawables = mProvider.getLogos();
        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                mProvider.setLogos(backUpDrawables);
                mProvider.setNames(backUpNames);
                mTopicsListViewAdapter = new topicsListViewAdapter(MainActivity.this,R.layout.activity_main,mProvider.getNames(),mProvider.getLogos(),"");
                mListView.setAdapter(mTopicsListViewAdapter);
                return true;
            }
        });
        mSearchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {

                    @Override
                    public boolean onQueryTextChange(String newText) {

                        ArrayList<String> names = new ArrayList<>();
                        ArrayList<Drawable> drawables = new ArrayList<>();
                        for(int i  = 0; i < mProvider.getNames().size();++i){
                             if(mProvider.getNames().get(i).contains(newText)){
                                 names.add(mProvider.getNames().get(i));
                                 drawables.add(mProvider.getLogos().get(i));
                             }
                        }
                        mProvider.setLogos(drawables);
                        mProvider.setNames(names);
                        mTopicsListViewAdapter = new topicsListViewAdapter(MainActivity.this,R.layout.activity_main,mProvider.getNames(),mProvider.getLogos(),newText);
                        mListView.setAdapter(mTopicsListViewAdapter);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        ArrayList<String> names = new ArrayList<>();
                        ArrayList<Drawable> drawables = new ArrayList<>();

                        for(int i = 0; i < mProvider.getNames().size();++i){
                            if(mProvider.getNames().get(i).contains(query) == false) {
                                names.add(mProvider.getNames().get(i));
                                drawables.add(mProvider.getLogos().get(i));
                            }
                        }
                        mTopicsListViewAdapter = new topicsListViewAdapter(MainActivity.this,R.layout.activity_main,mProvider.getNames(),mProvider.getLogos(),query);
                        mListView.setAdapter(mTopicsListViewAdapter);
                        return true;
                    }

                }
        );

        mListView.setItemsCanFocus(false);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(isNetworkAvailable() == true){

                Intent i2 = new Intent(MainActivity.this, NewsListActivity.class);
                i2.putExtra("type",mProvider.getName2(i));
                i2.putExtra("title",mProvider.getNames().get(i));
                startActivity(i2);
                }
                else{
                    Snackbar.make(view, "Internet is not available, please retry", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

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


}


