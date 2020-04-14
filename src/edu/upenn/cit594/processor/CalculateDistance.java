package edu.upenn.cit594.processor;

public class CalculateDistance {
    double x1;
    double y1;
    double x2;
    double y2;

    public double calculateDistanceBetweenTwoLocations() {
        return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
