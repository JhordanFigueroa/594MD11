package edu.upenn.cit594.processor;

import edu.upenn.cit594.data.State;
import edu.upenn.cit594.data.Tweet;
import edu.upenn.cit594.datamanagement​.CSVFileReader;
import edu.upenn.cit594.datamanagement​.JSONFileReader;
import edu.upenn.cit594.datamanagement​.Reader;
import edu.upenn.cit594.datamanagement​.TxtFileReader;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.ui.UserInterface;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Analyzer {
    String fileFormat;
    String fileName;
    String statesName;
    Logger logger = Logger.getInstance();

    public Analyzer() {
        this.fileFormat = StartProgram.getInstance().getTweetFileFormat();
        this.fileName = StartProgram.getInstance().getTweetFileName();
        this.statesName = StartProgram.getInstance().getStateFileName();

        boolean isFormatValid = fileFormat.equals("json") || fileFormat.equals("text");
        if (!isFormatValid) {
            UserInterface.display("ERROR: INVALID FORMAT FOR FILE");
            System.exit(0);
        }

        ArrayList<Tweet> tweets = new ArrayList<>();
        Set<Set<Tweet>> fluTweets = new HashSet<>();
        ArrayList<State> allStates = new ArrayList<>();

        allStates = CSVFileReader.getAllStates(statesName);

        FluTweet fl = new FluTweet();
        StateOfTweet st = new StateOfTweet();
        StateCount sc = new StateCount();
        String stateLocation = null;
        String tweetText = null;

        if (fileFormat.equals("json")) {
            Reader readerJSON = new JSONFileReader(fileName, fileFormat);
            tweets = readerJSON.getAllTweets();
            fluTweets.add(fl.getFluTweets(tweets));
            sc.getStateCount(st.getTweetStates(fluTweets, allStates));
//            logger.loggerPrint(); Needed to get the state and fluTweetText to pass into logger but I ran out of time
        }
        if (fileFormat.equals("text")) {
            Reader readerTxt = new TxtFileReader(fileName, fileFormat);
            tweets = readerTxt.getAllTweets();
            fluTweets.add(fl.getFluTweets(tweets));
            sc.getStateCount(st.getTweetStates(fluTweets, allStates));
//            logger.loggerPrint(); Needed to get the state and fluTweetText to pass into logger but I ran out of time
        }
    }
}
