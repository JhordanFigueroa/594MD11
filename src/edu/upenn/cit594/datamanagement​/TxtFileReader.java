package edu.upenn.cit594.datamanagement​;

import edu.upenn.cit594.data.Tweet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtFileReader implements Reader{

    protected String filename;
    protected String fileFormat;

    public TxtFileReader (String filename, String fileFormat) {
        this.filename = filename;
        this.fileFormat = fileFormat;
    }
    public ArrayList<Tweet> getAllTweets() {
        ArrayList<Tweet> tweets = new ArrayList<>();
        String fileToParse = filename + "." + fileFormat;
        try {
            Scanner scanner = new Scanner(new FileReader(fileToParse));
            if (fileToParse == null || fileToParse.length() == 0) { return tweets; }

            while (scanner.hasNextLine()) {
                String eachTweet = scanner.nextLine();
                if (eachTweet == null) {
                    break;
                }
                else {
                    String[] tweetSplit = eachTweet.split("\t");
                    String coordinatesSplit = tweetSplit[0].replace("[","").replace("]", "");
                    double tweetLatitude = Double.parseDouble(coordinatesSplit.substring(0, coordinatesSplit.indexOf(",")));
                    double tweetLongitude = Double.parseDouble(coordinatesSplit.substring(coordinatesSplit.indexOf(",") + 1));

                    String time = tweetSplit[2].trim();
                    String tweetText = tweetSplit[3].trim();

                    Tweet tweet = new Tweet(tweetText, time, tweetLatitude, tweetLongitude);
                    tweets.add(tweet);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("FILE DOES NOT EXIST");
            e.printStackTrace();
        }
        return tweets;
    }
}
