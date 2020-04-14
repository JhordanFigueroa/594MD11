package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.State;

import java.util.ArrayList;

public class StateTweet {

/*
1. Need to get the grid coordinates from filtered Flu tweets
2. Need to get the grid coordinates from states CSV
3. Calculate the distance
4. Match distance with a state
5. Match named states with flu tweets
 */

    public State states;
    public FluTweet fluTweet;

    public StateTweet (State state, FluTweet fluTweet) {
        this.states = state;
        this.fluTweet = fluTweet;
    }

    public ArrayList<String> getTweetStates() {

        return null;
    }
}
