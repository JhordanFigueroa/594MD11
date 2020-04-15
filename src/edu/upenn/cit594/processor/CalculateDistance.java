package edu.upenn.cit594.processor;

public class CalculateDistance {

    public double calculateDistanceBetweenTwoLocations(Double x1, Double y1, Double x2, Double y2) {
        double distance = 0;
        distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return distance;
    }
}
