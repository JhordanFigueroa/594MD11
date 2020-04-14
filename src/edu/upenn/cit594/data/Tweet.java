package edu.upenn.cit594.data;

import org.json.simple.JSONArray;

public class Tweet {
    private String text;
    private String time;
    private double latitude;
    private double longitude;
    private State state;

    public Tweet(String text, String time, Double latitude, Double longitude) {
        this.text = text;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters
    public String getText() {
        return text;
    }

    public String getTime() {
        return time;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
