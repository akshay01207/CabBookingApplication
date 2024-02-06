package com.thinkify.cabBookingApplication.model;

public class Driver {

	private final String name;
    private final String gender;
    private final int age;
    private final String vehicleNumber;
    private final Location currentLocation;
    private boolean available = true;

    public Driver(String name, String gender, int age, String vehicleNumber, Location currentLocation) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleNumber = vehicleNumber;
        this.currentLocation = currentLocation;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}