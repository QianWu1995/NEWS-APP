package com.example.qianwu.cookingrecipe.Model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by qianwu on 2017-09-13.
 */
public class NewsItem implements Parcelable {
    private String Heading;
    private String Descrption;
    private String author;
    private String url;
    private String urlToImage;
    private String Date;
    private String Source;
    private Topic mTopic;
    public NewsItem(String heading, String descrption, String author, String url, String urlToImage, String date, String source,Topic topic) {
        Heading = heading;
        Descrption = descrption;
        this.author = author;
        this.url = url;
        this.urlToImage = urlToImage;
        Date = date;
        Source = source;
        mTopic = topic;
    }



    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getDescrption() {
        return Descrption;
    }

    public void setDescrption(String descrption) {
        Descrption = descrption;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public Topic getTopic() {
        return mTopic;
    }

    public void setTopic(Topic topic) {
        mTopic = topic;
    }


    public NewsItem(Parcel in){
        String[] data = new String[8];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.Heading = data[0];
        this.Descrption = data[1];
        this.author = data[2];
        this.url = data[3];
        this.urlToImage = data[4];
        this.Date = data[5];
        this.Source = data[6];
        this.mTopic = null; // needs to be fixed
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(new String[]{
                this.Heading,
                this.Descrption,
                this.author,
                this.url,
                this.urlToImage,
                this.Date,
                this.Source,
                null
        });
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public NewsItem createFromParcel(Parcel in) {
            return new NewsItem(in);
        }

        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };
}

