package cabBookingApplication.service;

public class cabBookingApplicationMain {
	
	    public static void main(String[] args) {
	    	
	        cabBookingApplicationImplementation cabApplication = new cabBookingApplicationImplementation();

	        // Adding 3 users
	        cabApplication.addUser("Abhishek, M, 23");
	        cabApplication.addUser("Rahul, M, 29");
	        cabApplication.addUser("Nandini, F, 22");

	        // Adding 3 drivers
	        cabApplication.addDriver("Driver1, M, 22", "Swift, KA-01-12345", new int[]{10, 1});
	        cabApplication.addDriver("Driver2, M, 29", "Swift, KA-01-12345", new int[]{11, 10});
	        cabApplication.addDriver("Driver3, M, 24", "Swift, KA-01-12345", new int[]{5, 3});

	        // User trying to get a ride
	        System.out.println(cabApplication.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1}));  // Output: No ride found
	        System.out.println(cabApplication.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3}));    // Output: [Driver1]
	        System.out.println(cabApplication.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4}));  // Output: No ride found
	        System.out.println(cabApplication.chooseRide("Rahul", "Driver1")); // Output: Ride booked with Driver1
	    }
}