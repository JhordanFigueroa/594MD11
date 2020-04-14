package edu.upenn.cit594.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Logger {

    private PrintWriter out;

    //1. private constructor
    private Logger (String filename) {
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
    public static Logger getInstance() { return instance; }

    public void log(String msg) {
        out.println(msg);
        out.flush();
    }
}
