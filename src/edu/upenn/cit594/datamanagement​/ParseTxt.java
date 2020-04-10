package edu.upenn.cit594.datamanagement​;

import edu.upenn.cit594.data.Tweet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseTxt {
    public static List<String> readFile(String filename, String fileFormat) {
        String fileToParse = filename + "." + fileFormat;
        List<String> tweetList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new FileReader(fileToParse));
            if (filename == null || filename.length() == 0) { return tweetList; }

            while (scanner.hasNextLine()) {
                String eachTweet = scanner.nextLine();
                System.out.println(eachTweet);
                tweetList.add(eachTweet);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(tweetList);
        return tweetList;
    }
}
