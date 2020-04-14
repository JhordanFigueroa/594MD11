package edu.upenn.cit594;

import edu.upenn.cit594.data.State;
import edu.upenn.cit594.data.Tweet;
import edu.upenn.cit594.datamanagement​.CSVFileReader;
import edu.upenn.cit594.datamanagement​.JSONFileReader;
import edu.upenn.cit594.datamanagement​.Reader;
import edu.upenn.cit594.datamanagement​.TxtFileReader;
import edu.upenn.cit594.processor.FluTweet;
import edu.upenn.cit594.ui.UserInterface;

import java.util.ArrayList;

public class Main {
    // Program args:
    //  args[0] - file format, ex: json, txt
    //  args[1] - file name, ex: flu_tweets
    //  args[2] - the name of the states input file, ex: states.csv
    //  args[3] - the name of the log file

    public static void main (String[] args) {
        if (args.length < 4) {
            UserInterface.display("ERROR: INVALID NUMBER OF ARGS");
            return;
        }

        String fileName = args[1];
        String fileFormat = args[0];
        String states = args[2];

        boolean isFormatValid = fileFormat.equals("json") || fileFormat.equals("text");
        if (!isFormatValid) {
            UserInterface.display("ERROR: INVALID FORMAT FOR FILE");
            return;
        }

        ArrayList<Tweet> tweets = new ArrayList<>();
        FluTweet fl = new FluTweet();
        if (fileFormat.equals("json")) {
            Reader readerJSON = new JSONFileReader(fileName, fileFormat);
            tweets = readerJSON.getAllTweets();
            fl.getFluTweets(tweets);
        } else {
            Reader readerTxt = new TxtFileReader(fileName, fileFormat);
             tweets = readerTxt.getAllTweets();
             fl.getFluTweets(tweets);
        }

//        for (Tweet tweet : tweets) {
//            UserInterface.display(tweet.getText());
//            UserInterface.display(tweet.getTime());
//            UserInterface.display(tweet.getLatitude());
//            UserInterface.display(tweet.getLongitude());
////            UserInterface.display(tweet.getCoordinates());
//        }

//        ArrayList<State> allStates = new ArrayList<>();
//        allStates = CSVFileReader.getAllStates(states);
//
//        for (State st : allStates) {
//            UserInterface.display(st.getState());
//            UserInterface.display(st.getLatitude());
//            UserInterface.display(st.getLongitude());
//        }

        //Create the objects and their relationships:
    }
}