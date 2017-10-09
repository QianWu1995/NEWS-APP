package com.robin.qianwu.cookingrecipe.Model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

import com.robin.qianwu.cookingrecipe.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by qianwu on 2017-09-13.
 */
public class NewsProvider {
    ArrayList<String> names;
    ArrayList<Drawable> logos;
    ArrayList<String> names2;
    public NewsProvider(Context context) {
        names = new ArrayList<>(Arrays.asList("ABC News(AU)", "Al Jazeera English","Ars Technica",
                "Associated Press","BBC News","BBC Sport","Bild","Bloomberg","Breitbart News",
                "Business Insider","Business Insider (UK)", "Buzzfeed","CNBC","CNN",
                "Daily Mail","Der Tagesspiegel","Die Zeit","Engadget","Entertainment Weekly",
                "ESPN","ESPN Cric Info","Financial Times","Focus",
                "Football Italia","Fortune","FourFourTwo","Fox Sports","Google News","Gruenderszene",
                "Hacker News","Handelsblatt","IGN","Independent","Mashable","Metro","Mirror",
                "MTV News","MTV News (UK)","National Geographic","New Scientist","Newsweek",
                "New York Magazine","NFL News","Polygon","Recode","Reddit /r/all","Reuters",
                "Spiegel Online","T3n","TalkSport","TechCrunch","TechRadar","The Economist",
                "The Guardian (AU)","The Guardian (UK)","The Hindu","The Huffington Post","The Lad Bible",
                "The New York Times","The Next Web","The Sport Bible","The Telegraph","The Times of India",
                "The Verge","The Wall Street Journal","The Washington Post","Time","USA Today","Wired.de",
                "Wirtschafts Woche"));

        names2 = new ArrayList<>(Arrays.asList("abc-news-au", "al-jazeera-english","ars-technica",
                "associated-press","bbc-news","bbc-sport","bild","bloomberg","breitbart-news",
                "business-insider","business-insider-uk", "buzzfeed","cnbc","cnn",
                "daily-mail","der-tagesspiegel","die-zeit","engadget","entertainment-weekly",
                "espn","espn-cric-info","financial-times","focus",
                "football-italia","fortune","four-four-two","fox-sports","google-news","gruenderszene",
                "hacker-news","handelsblatt","ign","independent","mashable","metro","mirror",
                "mtv-news","mtv-news-uk","national-geographic","new-scientist","newsweek",
                "new-york-magazine","nfl-news","polygon","recode","reddit-r-all","reuters",
                "spiegel-online","t3n","talksport","techcrunch","techradar","the-economist",
                "the-guardian-au","the-guardian-uk","the-hindu","the-huffington-post","the-lad-bible",
                "the-new-york-times","the-next-web","the-sport-bible","the-telegraph","the-times-of-india",
                "the-verge","the-wall-street-journal","the-washington-post","time","usa-today","wired-de",
                "wirtschafts-woche"));

        logos = new ArrayList<>(Arrays.asList(ContextCompat.getDrawable(context,R.drawable.abc),
                ContextCompat.getDrawable(context,R.drawable.ajz),
                ContextCompat.getDrawable(context,R.drawable.at),
                ContextCompat.getDrawable(context,R.drawable.ap),
                ContextCompat.getDrawable(context,R.drawable.bbc),
                ContextCompat.getDrawable(context,R.drawable.bbcsport),
                ContextCompat.getDrawable(context,R.drawable.bild),
                ContextCompat.getDrawable(context,R.drawable.bloomberg),
                ContextCompat.getDrawable(context,R.drawable.breitbartnews),
                ContextCompat.getDrawable(context,R.drawable.bi),
                ContextCompat.getDrawable(context,R.drawable.biuk),
                ContextCompat.getDrawable(context,R.drawable.buzzfeed),
                ContextCompat.getDrawable(context,R.drawable.cnbc),
                ContextCompat.getDrawable(context,R.drawable.cnn),
                ContextCompat.getDrawable(context,R.drawable.dailymail),
                ContextCompat.getDrawable(context,R.drawable.der_tag),
                ContextCompat.getDrawable(context,R.drawable.diezeit),
                ContextCompat.getDrawable(context,R.drawable.engadget),
                ContextCompat.getDrawable(context,R.drawable.ew),
                ContextCompat.getDrawable(context,R.drawable.espn),
                ContextCompat.getDrawable(context,R.drawable.espncric),
                ContextCompat.getDrawable(context,R.drawable.financialtimes),
                ContextCompat.getDrawable(context,R.drawable.focus),
                ContextCompat.getDrawable(context,R.drawable.footballitalia),
                ContextCompat.getDrawable(context,R.drawable.fortune),
                ContextCompat.getDrawable(context,R.drawable.four442),
                ContextCompat.getDrawable(context,R.drawable.foxsports),
                ContextCompat.getDrawable(context,R.drawable.googlenews),
                ContextCompat.getDrawable(context,R.drawable.gruenders),
                ContextCompat.getDrawable(context,R.drawable.hn),
                ContextCompat.getDrawable(context,R.drawable.handelsblatt),
                ContextCompat.getDrawable(context,R.drawable.ign),
                ContextCompat.getDrawable(context,R.drawable.indenpendent),
                ContextCompat.getDrawable(context,R.drawable.mashable),
                ContextCompat.getDrawable(context,R.drawable.metro),
                ContextCompat.getDrawable(context,R.drawable.mirror),
                ContextCompat.getDrawable(context,R.drawable.mtv_news),
                ContextCompat.getDrawable(context,R.drawable.mtvnewsuk),
                ContextCompat.getDrawable(context,R.drawable.nationalgeographic),
                ContextCompat.getDrawable(context,R.drawable.newscientists),
                ContextCompat.getDrawable(context,R.drawable.newsweek),
                ContextCompat.getDrawable(context,R.drawable.newyorkmaga),
                ContextCompat.getDrawable(context,R.drawable.nflnews),
                ContextCompat.getDrawable(context,R.drawable.polygon),
                ContextCompat.getDrawable(context,R.drawable.recode),
                ContextCompat.getDrawable(context,R.drawable.reddit),
                ContextCompat.getDrawable(context,R.drawable.reuters),
                ContextCompat.getDrawable(context,R.drawable.spiegels),
                ContextCompat.getDrawable(context,R.drawable.t3n),
                ContextCompat.getDrawable(context,R.drawable.talksport),
                ContextCompat.getDrawable(context,R.drawable.techcrunch),
                ContextCompat.getDrawable(context,R.drawable.techradar),
                ContextCompat.getDrawable(context,R.drawable.economist),
                ContextCompat.getDrawable(context,R.drawable.guardian),
                ContextCompat.getDrawable(context,R.drawable.guardian),
                ContextCompat.getDrawable(context,R.drawable.thehindu),
                ContextCompat.getDrawable(context,R.drawable.huffingtonpost),
                ContextCompat.getDrawable(context,R.drawable.theladbible),
                ContextCompat.getDrawable(context,R.drawable.newyorktimes),
                ContextCompat.getDrawable(context,R.drawable.thenextweb),
                ContextCompat.getDrawable(context,R.drawable.sportbible),
                ContextCompat.getDrawable(context,R.drawable.telegraph),
                ContextCompat.getDrawable(context,R.drawable.timesofindia),
                ContextCompat.getDrawable(context,R.drawable.verge),
                ContextCompat.getDrawable(context,R.drawable.wallstrretjournal),
                ContextCompat.getDrawable(context,R.drawable.wp),
                ContextCompat.getDrawable(context,R.drawable.time),
                ContextCompat.getDrawable(context,R.drawable.usatoday),
                ContextCompat.getDrawable(context,R.drawable.wiredde),
                ContextCompat.getDrawable(context,R.drawable.ww)
        ));

    }
    public String getName2(int index){
        return names2.get(index);


    }

    public void setNames(ArrayList<String> names) {
        this.names = names;
    }

    public void setLogos(ArrayList<Drawable> logos) {
        this.logos = logos;
    }

    public ArrayList<String> getNames2() {
        return names2;
    }

    public void setNames2(ArrayList<String> names2) {
        this.names2 = names2;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Drawable> getLogos() {
        return logos;
    }
}
