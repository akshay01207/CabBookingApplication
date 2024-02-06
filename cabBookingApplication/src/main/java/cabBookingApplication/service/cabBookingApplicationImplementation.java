package cabBookingApplication.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkify.cabBookingApplication.model.Driver;
import com.thinkify.cabBookingApplication.model.Location;
import com.thinkify.cabBookingApplication.model.User;

public class cabBookingApplicationImplementation {
	
	    private final Map<String, User> users = new HashMap<>();
	    private final Map<String, Driver> drivers = new HashMap<>();

	    
	    //addUser Details
	    public void addUser(String userDetails) {
	        String[] details = userDetails.split(", ");
	        String name = details[0];
	        String gender = details[1];
	        int age = Integer.parseInt(details[2]);
	        users.put(name, new User(name, gender, age));
	    }
	    
	    //AddDriver Details
	    public void addDriver(String driverDetails, String vehicleNumber, int[] currentLocation) {
	        String[] details = driverDetails.split(", ");
	        String name = details[0];
	        String gender = details[1];
	        int age = Integer.parseInt(details[2]);
	        int a = currentLocation[0];
	        int b = currentLocation[1];
	        drivers.put(name, new Driver(name, gender, age, vehicleNumber, new Location(a, b)));
	    }

	    public List<String> findRide(String username, int[] source, int[] destination) {
	        User user = users.get(username);
	        if (user == null) {
	            return List.of("User not found");
	        }

	        List<String> availableRides = new ArrayList<>();
	        
	        for (Driver driver : drivers.values()) {
	        	
	            if (driver.isAvailable() && driver.getCurrentLocation().distance(new Location(source[0], source[1])) <= 5) {
	                availableRides.add(driver.getName());
	            }
	        }

	        if (availableRides.isEmpty()) {
	            return List.of("No ride found");
	            
	        } else {
	            return availableRides;
	        }
	    }

	    public String chooseRide(String username, String driverName) {
	    	
	        User user = users.get(username);
	        if (user == null) {
	            return "User not found";
	        }

	        Driver driver = drivers.get(driverName);
	        if (driver == null || !driver.isAvailable()) {
	            return "Invalid or unavailable driver";
	        }

	        driver.setAvailable(false);
	        return "Ride booked with " + driverName;
	    }
	}