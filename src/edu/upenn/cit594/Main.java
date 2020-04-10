package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement​.ParseJson;
import edu.upenn.cit594.datamanagement​.ParseTxt;

public class Main {

    public static void main (String[] args) {
        // Expected ARGS:
        //file format  ex: json, txt                                                        args[0]
        //file name ex: flu_tweets                                                          args[1]
        //the name of the states input file  ex: states.csv                                 args[2]
        //the name of the log file (for logging debug information; see “Logging” below)     args[3]

        if (args.length < 4) {
            System.out.println("ERROR: INVALID NUMBER OF ARGS");
            return;
        }

        String fileFormat = args[0];
        boolean isFormatValid = fileFormat.equals("json") || fileFormat.equals("txt");
        if (!isFormatValid) {
            System.out.println("ERROR: INVALID FORMAT FOR FILE");
            return;
        }
//
//        ParseJson.parse(args[1], args[0]);
        ParseTxt.readFile(args[1], args[0]);
    }
}
