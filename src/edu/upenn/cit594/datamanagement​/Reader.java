package edu.upenn.cit594.datamanagement​;

import edu.upenn.cit594.data.Tweet;

import java.util.ArrayList;

public interface Reader {

    public ArrayList<Tweet> getAllTweets();
}
