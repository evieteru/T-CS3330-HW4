package hw4;

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
		
		
		// Test for maintenance cost-related functions
		Vehicle highestCost = getVehicleWithHighestMaintenanceCost(100.0);
		System.out.println("\nVehicle with highest cost:\n" + highestCost.toString());
	
		Vehicle lowestCost = getVehicleWithLowestMaintenanceCost(100.0);
		System.out.println("\nVehicle with lowest cost:\n" + lowestCost.toString());
		
		
	}

}
