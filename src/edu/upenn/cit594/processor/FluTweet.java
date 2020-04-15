package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.Tweet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FluTweet {
    Set<Tweet> fluTweets = new HashSet<>();
    String fluPattern = "(((?i)flu\\W)|FLU\\z)";


    public Set<Tweet> getFluTweets(ArrayList<Tweet> allTweets) {
        Pattern p = Pattern.compile(fluPattern);

        for (Tweet tw : allTweets) {
            String tweetContent = tw.getText();
            String tweetTime = tw.getTime();
            double tweetLatitude = tw.getLatitude();
            double tweetLongitude = tw.getLongitude();

            Matcher match = p.matcher(tweetContent);
            while (match.find()) {

                Tweet fluTweet = new Tweet(tweetContent, tweetTime, tweetLatitude, tweetLongitude);
                fluTweets.add(fluTweet);
            }
        }
        return fluTweets;
    }
}
