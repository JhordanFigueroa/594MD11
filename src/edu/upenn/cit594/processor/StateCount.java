package edu.upenn.cit594.processor;

import java.util.HashMap;
import java.util.TreeMap;

public class StateCount {

    public TreeMap<String, Integer> getStateCount(HashMap<String, String> tweetLocations) {
        TreeMap<String, Integer> finalStateFluTweetCount = new TreeMap<>();
        String stateLocation = null;

        int totalCount = 0;
        for (String key : tweetLocations.keySet()) {
            stateLocation = tweetLocations.get(key);
            String tweetText = key;
            System.out.println("The FluTweet: " + tweetText + "\nis located at : "  + stateLocation);

            if (!stateLocation.isEmpty()) {
                totalCount++;
                finalStateFluTweetCount.put(stateLocation, totalCount);
            }
        }
        //Ran out of time trying to figure out how to get the proper count to display.
        for (String s : finalStateFluTweetCount.keySet()) {
            System.out.println(s + ": " + finalStateFluTweetCount.get(s));
        }
        return finalStateFluTweetCount;
    }
}
