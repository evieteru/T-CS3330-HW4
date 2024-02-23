package hw4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		VehicleManager testManager = VehicleManager.getInstance(); //create an instance of VehicleManager
		
		// Create some monsters truck and car
		Car testCar = new Car("Toyota", "Camry", 2020, 30000, 25.5, 4, 15.0, 1500.0, VehicleColor.BLUE, FuelType.GASOLINE, StartMechanism.KEYSTART);
        	Truck testTruck = new Truck("Ford", "F-150", 2019, 35000, 20.0, 6, 20.0, 2000.0, VehicleColor.RED, FuelType.DIESEL, StartMechanism.PUSHSTART);
		boolean initialize;
		boolean save;
		initialize = testManager.initializeStock();
		save = testManager.saveVehicleList();
		
		if (initialize == true && save == true) {
			System.out.println("Initialized and saved successfully. Here is the complete data: "); 
			testManager.displayAllVehicleInformation();
		}
		else {
			System.out.println("Something went wrong, check the file path or its data");
			System.exit(0); //Exit program upon failure to initialize or save inventory
		}
		
		
		// Test maintenance-cost related functions
		Vehicle highestCost = testManager.getVehicleWithHighestMaintenanceCost(100.0);
		System.out.println("\nVehicle with highest cost:" + highestCost.toString());
	
		Vehicle lowestCost = testManager.getVehicleWithLowestMaintenanceCost(100.0);
		System.out.println("\nVehicle with lowest cost:" + lowestCost.toString());
		
		// Test fuel-efficiency related functions
		System.out.println("\nVehicles with highest fuel efficiencies");
		ArrayList<Vehicle> highestFuelEfficiencies = new ArrayList<Vehicle>();
		highestFuelEfficiencies = testManager.getVehicleWithHighestFuelEfficiency(100, 2);
		for (Vehicle vehicle : highestFuelEfficiencies) {
			System.out.println(vehicle.toString());
		}
		
		System.out.println("\nVehicles with lowest fuel efficiencies");
		ArrayList<Vehicle> lowestFuelEfficiencies = new ArrayList<Vehicle>();
		lowestFuelEfficiencies = testManager.getVehicleWithLowestFuelEfficiency(100, 2);
		for (Vehicle vehicle : lowestFuelEfficiencies) {
			System.out.println(vehicle.toString());
		}
		
	
		double avgSuvFuelEfficiency;
		avgSuvFuelEfficiency = testManager.getAverageFuelEfficiencyOfSUVs(100, 2);
		System.out.println("Avg SUV Fuel Efficiency = " + avgSuvFuelEfficiency);
		
		// Test all display functions
		System.out.println("\n\nPrinting all cars:");
		testManager.displayAllCarInformation();

		//Thomas 
		// Add vehicles
        	boolean addedCar = testManager.addVehicle(testCar);
        	System.out.println("Car added is: " + addedCar);

        	boolean addedTruck = testManager.addVehicle(testTruck);
        	System.out.println("Truck added is: " + addedTruck);

        	// Remove vehicle
        	boolean removedCar = testManager.removeVehicle(testCar);
        	System.out.println("Car removed is: " + removedCar);

        	// Save vehicle list
        	boolean savedList = testManager.saveVehicleList();
        	System.out.println("List saved: " + savedList);

        	// Check a specific type
        	boolean isCarType = testManager.isVehicleType(testCar, Car.class); // Please public this method if need to test
        	System.out.println("Is testCar a Car: " + isCarType);

        	// Check number of truck type
        	int numberOfTrucks = testManager.getNumberOfVehichlesByType(Truck.class);
        	System.out.println("Number of Trucks: " + numberOfTrucks);
        
        	// Display all 
        	testManager.displayAllVehicleInformation();
    
		
	}

}
