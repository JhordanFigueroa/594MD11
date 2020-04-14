package edu.upenn.cit594.datamanagement​;

import edu.upenn.cit594.data.State;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CSVFileReader {

    protected String filename;

    public CSVFileReader (String filename) {
        this.filename = filename;
    }

    public static ArrayList<State> getAllStates(String filename) {
//        List<String[]> stateData = new LinkedList<>();
        ArrayList<State> stateData = new ArrayList<>();
        String stateRow;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((stateRow = br.readLine()) != null) {
                String[] stateInfo = stateRow.split(",");

                String state = stateInfo[0].trim();
                double stateLatitude = Double.parseDouble(stateInfo[1].trim());
                double stateLongitude = Double.parseDouble(stateInfo[2].trim());

                State stateDetails = new State(state, stateLatitude, stateLongitude);

//                System.out.println(stateDetails);
                stateData.add(stateDetails);
            }
        } catch (FileNotFoundException e) {
            System.out.println("COULD NOT FIND FILE");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("COULD NOT READ FILE");
            e.printStackTrace();
        }

//        for (State state : stateData) {
//            System.out.println(state);
//        }

        return stateData;
    }
}
