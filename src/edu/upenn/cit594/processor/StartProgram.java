package edu.upenn.cit594.processor;

import edu.upenn.cit594.ui.UserInterface;

public class StartProgram {

    private String tweetFileFormat;
    private String tweetFileName;
    private String stateFileName;
    private String loggerFileName;
    private static String[] correctArgs;

    public StartProgram (String[] args) {
        if (args.length < 4) {
            UserInterface.display("ERROR: INVALID NUMBER OF ARGS");
            UserInterface.display("YOU MUST ENTER AT LEAST 4 ARGUMENTS OF THE FOLLOWING:" +
                    "\n 1st: file type (text or json)" +
                    "\n 2nd: name of the tweet file" +
                    "\n 3rd: name of the states file" +
                    "\n 4th: log file name if you have one");
            System.exit(0);
        }
        correctArgs = args;
        setTweetFileFormat(args[0]);
        setTweetFileName(args[1]);
        setStateFileName(args[2]);
        setLoggerFileName(args[3]);
    }

    public String getTweetFileFormat() {
        return tweetFileFormat;
    }

    public String getTweetFileName() {
        return tweetFileName;
    }

    public String getStateFileName() {
        return stateFileName;
    }

    public String getLoggerFileName() {
        return loggerFileName;
    }

    private static StartProgram instance;
    public static StartProgram getInstance() {
        if (instance == null) {
            instance = new StartProgram(correctArgs);
        }
        return instance;
    }

    public void setTweetFileFormat(String tweetFileFormat) {
        this.tweetFileFormat = tweetFileFormat;
    }

    public void setTweetFileName(String tweetFileName) {
        this.tweetFileName = tweetFileName;
    }

    public void setStateFileName(String stateFileName) {
        this.stateFileName = stateFileName;
    }

    public void setLoggerFileName(String loggerFileName) {
        this.loggerFileName = loggerFileName;
    }
}
