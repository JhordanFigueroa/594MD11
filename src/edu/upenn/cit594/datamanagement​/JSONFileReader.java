package edu.upenn.cit594.datamanagement​;

import edu.upenn.cit594.data.Tweet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONFileReader implements Reader{

    protected String filename;
    protected String fileFormat;

    public JSONFileReader (String filename, String fileFormat) {
        this.filename = filename;
        this.fileFormat = fileFormat;
    }

    public ArrayList<Tweet> getAllTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();

        String fileToParse = filename + "." + fileFormat;
        JSONParser parser = new JSONParser();
        try {
            JSONArray Tweets = (JSONArray) parser.parse(new FileReader(fileToParse));
            if (fileToParse == null || fileToParse.length() == 0) { return tweets; }

            Iterator iter = Tweets.iterator();
            while (iter.hasNext()) {
                JSONObject tweetJsonObject = (JSONObject) iter.next();

                String text = (String) tweetJsonObject.get("text");
                String time = (String) tweetJsonObject.get("time");
                JSONArray coordinates = (JSONArray)  tweetJsonObject.get("location");
                Double latitude = (Double) coordinates.get(0);
                Double longitude = (Double) coordinates.get(1);

                Tweet tweet = new Tweet(text, time, latitude, longitude);
                tweets.add(tweet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return tweets;
    }
}
