package com.thinkify.cabBookingApplication.model;

public class Location {
    private final int a;
    private final int b;

    public Location(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double distance(Location endPoint) {
        return Math.sqrt(Math.pow(a - endPoint.a, 2) + Math.pow(b - endPoint.b, 2));
    }
}
