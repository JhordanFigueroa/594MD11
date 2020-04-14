package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.Tweet;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FluTweet {
    ArrayList<Tweet> fluTweets = new ArrayList<>();
    String fluPattern = "\\W*(?i)(flu)(?-i)\\W";

    public ArrayList<Tweet> getFluTweets(ArrayList<Tweet> allTweets) {
        Pattern p = Pattern.compile(fluPattern);

        for (Tweet tw : allTweets) {
            String tweetContent = tw.getText();
            String tweetTime = tw.getTime();
            double tweetLatitude = tw.getLatitude();
            double tweetLongitude = tw.getLongitude();

            Matcher match = p.matcher(tweetContent);
            while (match.find()) {
                System.out.println(tweetContent);
                System.out.println(tweetLatitude);
                System.out.println(tweetLongitude);

                Tweet fluTweet = new Tweet(tweetContent, tweetTime, tweetLatitude, tweetLongitude);
                fluTweets.add(fluTweet);
            }
        }
        return fluTweets;
    }
}
