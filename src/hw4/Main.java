package hw4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		VehicleManager testManager = VehicleManager.getInstance(); //create an instance of VehicleManager
		
		
		boolean initialize;
		boolean save;
		initialize = testManager.initializeStock();
		save = testManager.saveVehicleList();
		
		if (initialize == true && save == true) {
			System.out.println("Initialized and saved successfully"); 
			//print array here
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
		
	}

}
