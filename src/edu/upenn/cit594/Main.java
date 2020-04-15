package edu.upenn.cit594;

import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.*;

public class Main {

    public static void main (String[] args) {

        new StartProgram(args);

        new Analyzer();

        Logger.getInstance();
    }
}

