package edu.upenn.cit594.logging;

import edu.upenn.cit594.processor.StartProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Logger {

    private PrintWriter out;

    //1. private constructor
    private Logger (String filename) {
        filename = StartProgram.getInstance().getLoggerFileName();
        try {
            out = new PrintWriter(new File(filename));
        }
        catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
            e.printStackTrace();
        }
    }

    //2. Singleton Instance
    private static Logger instance;

    //3. Singleton Accessor Method
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger(StartProgram.getInstance().getLoggerFileName());
        }
        return instance; }

    public void loggerPrint(String msg) {
        out.println(msg);
        out.flush();
    }

    public String getLoggerFileName() {
        return StartProgram.getInstance().getLoggerFileName();
    }
}
