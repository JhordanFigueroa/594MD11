package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.State;
import edu.upenn.cit594.data.Tweet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class StateOfTweet {

    public HashMap<String, String> getTweetStates(Set<Set<Tweet>> fluTweets, ArrayList<State> allStates) {
        double tweetLatitude = 0;
        double tweetLongitude = 0;
        String tweetText;
        String stateName;
        double stateLatitude = 0;
        double stateLongitude = 0;

        CalculateDistance cd = new CalculateDistance();
        HashMap<String, String> fluTweetLocations = new HashMap<>();

        for (Set<Tweet> tw :fluTweets) {
            for (Tweet tweetObj : tw) {
                double minDistance = Double.MAX_VALUE;
                String matchingState = null;
                tweetText = tweetObj.getText();
                tweetLatitude = tweetObj.getLatitude();
                tweetLongitude = tweetObj.getLongitude();

                for (State st : allStates) {
                    stateName = st.getState();
                    stateLatitude = st.getLatitude();
                    stateLongitude = st.getLongitude();

                    double calculatedDistance = cd.calculateDistanceBetweenTwoLocations(tweetLatitude, tweetLongitude, stateLatitude, stateLongitude);

                    if (calculatedDistance < minDistance) {
                        minDistance = calculatedDistance;
                        matchingState = stateName;
                    }
                }
                fluTweetLocations.put(tweetText, matchingState);
            }
        }

        return fluTweetLocations;
    }
}
