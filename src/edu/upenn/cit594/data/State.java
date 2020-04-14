package edu.upenn.cit594.data;

public class State {
    private String state;
    private double latitude;
    private double longitude;

    public State (String state, Double latitude, Double longitude) {
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Getters
    public String getState() { return state; }

    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }


}
