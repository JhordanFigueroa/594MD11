package edu.upenn.cit594.datamanagement​;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class ParseJson {

    public static void parse(String filename, String fileFormat) {
        String fileToParse = filename + "." + fileFormat;
        JSONParser parser = new JSONParser();
        try {
            JSONArray Tweets = (JSONArray) parser.parse(new FileReader(fileToParse));

            Iterator iter = Tweets.iterator();
            while (iter.hasNext()) {
                JSONObject Tweet = (JSONObject) iter.next();
                System.out.println(Tweet.get("text"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
}
