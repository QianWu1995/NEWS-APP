package com.robin.qianwu.cookingrecipe.Model;

/**
 * Created by qianwu on 2017-09-13.
 */
public class NewsItem {
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




}

