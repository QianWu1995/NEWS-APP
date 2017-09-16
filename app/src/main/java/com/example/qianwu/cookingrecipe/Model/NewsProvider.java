package com.example.qianwu.cookingrecipe.Model;

/**
 * Created by qianwu on 2017-09-13.
 */
public class NewsProvider {
    String Name;
    String url;
    Topic topic;

    public NewsProvider(String name, String url, Topic topic) {
        Name = name;
        this.url = url;
        this.topic = topic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
