package edu.upenn.cit594.data;

public class Tweet {
    protected float location;
//    protected float latitude;
//    protected float longitude;
    protected String text;

    public Tweet(float location, String text) {
        this.location = location;
        this.text = text;
    }

    public float getLocation() { return location;}

    public String getText() { return text;}
}
