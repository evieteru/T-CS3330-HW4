/*
 * Sources used: https://beginnersbook.com/2013/12/how-to-empty-an-arraylist-in-java/
 */
package hw4;
import java.util.*;
import java.io.*;

public class VehicleManager {
	
	
	//Fields
	private static VehicleManager instance;
	private final static String inventoryFilePath = "files/vehicleList.csv";
	ArrayList<Vehicle> vehicleList = new ArrayList<>();
	
	//Pass as inputs into calculateMaintenanceCost & calculateFuelEfficiency
	private final static double distance = 300;
	private final static double fuelPrice = 3.25; 
	
	private VehicleManager() {
		//private method to prevent outside instantiation
	}
	
	
	//Static method to provide access to the single instance
	 public static VehicleManager getInstance() {
	 
	 	//create instance if it doesn't exist
	 	if (instance == null){
	 		instance = new VehicleManager();
	 	}
	 	
	 	return instance;
	 	}

	
	
	public boolean initializeStock() {
		
	//REMAINING CONCERNS (ask someone):
		//- do we need to wrap the enum parsing lines in try catch blocks? Something about type safety
		
		try {
			File vehicleFile = new File(inventoryFilePath);
			Scanner scanner = new Scanner(vehicleFile);
			
			scanner.nextLine(); //Skips first line of the file, no needed info.
			
			while(scanner.hasNextLine()) { //while not at the end of the file
				String line = scanner.nextLine();
				String[] parts = line.split(","); //breaks a line into an array with each index containing something that was before a comma
				
				//parsing data and assigning to fields. 
				String type = parts[0];
				String brand = parts[1];
				String make = parts[2];
				long modelYear = Long.parseLong(parts[3]);
				double price = Double.parseDouble(parts[4]);
				VehicleColor color = VehicleColor.valueOf(parts[5].toUpperCase());
				FuelType fuelType = FuelType.valueOf(parts[6].toUpperCase());
				double mileage = Double.parseDouble(parts[7]);
				double mass = Double.parseDouble(parts[8]);
				int cylinders = Integer.parseInt(parts[9]);
				double gasTankCapacity = Double.parseDouble(parts[10]);
				StartMechanism startType = StartMechanism.valueOf(parts[11].toUpperCase());
				
				
				//Creating objects of specified subclasses and adding them to the main list
				switch (type) {
				case "Car":
					Car car = new Car(brand, make, modelYear, price, mileage, cylinders, gasTankCapacity, mass, color, fuelType, startType);
					vehicleList.add(car);
					break;
					
				case "Truck":
					Truck truck = new Truck(brand, make, modelYear, price, mileage, cylinders, gasTankCapacity, mass, color, fuelType, startType);
					vehicleList.add(truck);
					break;
					
				case "SUV":
					SUV suv = new SUV(brand, make, modelYear, price, mileage, cylinders, gasTankCapacity, mass, color, fuelType, startType);
					vehicleList.add(suv);
					break;
					
				case "MotorBike":
					MotorBike motorbike = new MotorBike(brand, make, modelYear, price, mileage, cylinders, gasTankCapacity, mass, color, fuelType, startType);
					vehicleList.add(motorbike);
					break;
					
				default:
					System.out.println("Unknown vehicle type");
					continue;
				}
				
			}
			
			//close the scanner, return true for success
			scanner.close();
			return true;
		
		}
		
		//catching errors
		catch(FileNotFoundException e) {
			System.err.println("File not found: " + inventoryFilePath);
			return false;
		}
		catch(NumberFormatException e) {
			System.err.println("Error parsing value in file");
			return false;
		}
	}
	
	
	
	public boolean saveVehicleList() {
		
		try {
			FileWriter writer = new FileWriter(inventoryFilePath);
		
		
			writer.write("Type,Brand,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType\n");
			
			
			for(Vehicle vehicle : vehicleList) {
				
				String data = vehicle.toCSVString() + "\n";
				writer.write(data);
				
			}
			
			writer.close();
			return true;
	    }
		
	  catch (IOException e) {
		e.printStackTrace();
		return false;
	}
	
	}
	
	
	
	
	
	
	
	
	//Display all Cars or error message if none
	public void displayAllCarInformation() {
		boolean carFound = false;
		for (Vehicle vehicle : vehicleList) {
			if (vehicle instanceof Car) {
				System.out.println(vehicle.toString());
				carFound = true;
			}
		}
		if (!carFound) {
			System.out.println("No cars are in the Vehicle Manager.");
		}
	}
	
	//Display all Trucks or error message if none
	public void displayAllTruckInformation() {
		boolean truckFound = false;
		for (Vehicle vehicle : vehicleList) {
			if (vehicle instanceof Truck) {
				System.out.println(vehicle.toString());
				truckFound = true;
			}
		}
		if (!truckFound) {
			System.out.println("No trucks are in the Vehicle Manager.");
		}
	}
	
	//Display all SUVs or error message if none
	public void displayAllSUVInformation() {
		boolean suvFound = false;
		for (Vehicle vehicle : vehicleList) {
			if (vehicle instanceof SUV) {
				System.out.println(vehicle.toString());
				suvFound = true;
			}
		}
		if (!suvFound) {
			System.out.println("No SUVs are in the Vehicle Manager.");
		}
	}
	
	//Display all Motor Bikes or error message if none
	public void displayAllMotorBikeInformation() {
		boolean motorBikeFound = false;
		for (Vehicle vehicle : vehicleList) {
			if (vehicle instanceof MotorBike) {
				System.out.println(vehicle.toString());
				motorBikeFound = true;
			}
		}
		if (!motorBikeFound) {
			System.out.println("No motorbikes are in the Vehicle Manager.");
		}
	}
	
	// Display one vehicle's information
	public void displayVehicleInformation(Vehicle v) {
		try {
			System.out.println("\nVehicle information: ");
			System.out.println(v.toString());
		} catch(Exception e) {
			System.out.println("Invalid vehicle; Cannot print information.");
		}
	}
	
	// Display all vehicle information in vehicleList array or error message if it is empty
	public void displayAllVehicleInformation() {
		if (vehicleList.isEmpty()) {
			System.out.println("No vehicles are in the Vehicle Manager.");
		}
		else {
			for (Vehicle vehicle : vehicleList) {
				System.out.println(vehicle.toString());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//General
	
	public boolean removeVehicle(Vehicle vehicle) {
		// Do something
		return false;
		
	}
	
	
	public boolean addVehicle(Vehicle vehicle) {
		// Do something
		return false;	
	}
	
	
	
	private boolean isVehicleType(Vehicle v, Class clazz) {
		// Do something
		return false;
	}
	
	
	
	
	
	
	
	//Vehicle Search
	public int getNumberOfVehichlesByType(Class clazz){
		// Do something
		return -1;
	}
	
	
	
	
	
	
	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle with the highest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the vehicles (Use the Random class for random selection).
	 * @param distance
	 * @return Vehicle
	 */
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		ArrayList<Vehicle> duplicates = new ArrayList<Vehicle>();
		double maintenanceCost;
		
		Vehicle vehicleWithHighestCost = vehicleList.get(0);
		double highestCost = vehicleWithHighestCost.calculateMaintenanceCost(distance);
		
		for (Vehicle vehicle : vehicleList) {
			maintenanceCost = vehicle.calculateMaintenanceCost(distance);
			if (maintenanceCost > highestCost) {
				highestCost = maintenanceCost;
				vehicleWithHighestCost = vehicle;
				duplicates.clear(); // New highestCost founded, so clear old arrayList
			}
			else if (maintenanceCost == highestCost) {
				duplicates.add(vehicle);
			}
		}
		
		if (duplicates.isEmpty()) { // Means only 1 Vehicle with highestCost
			return vehicleWithHighestCost;
		}
		else { // Return random vehicle in list of Vehicles with same highestCost
			Random randomNum = new Random(); // Create random instance			
			int randomIndex = randomNum.nextInt(duplicates.size());
			return duplicates.get(randomIndex);
		}
	}
	
	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle with the lowest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the vehicles (Use the Random class for random selection).
	 * @param distance
	 * @return Vehicle
	 */
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance){
		ArrayList<Vehicle> duplicates = new ArrayList<Vehicle>();
		double maintenanceCost;
		
		Vehicle vehicleWithLowestCost = vehicleList.get(0);
		double lowestCost = vehicleWithLowestCost.calculateMaintenanceCost(distance);
		
		for (Vehicle vehicle : vehicleList) {
			maintenanceCost = vehicle.calculateMaintenanceCost(distance);
			if (maintenanceCost < lowestCost) {
				lowestCost = maintenanceCost;
				vehicleWithLowestCost = vehicle;
				duplicates.clear(); // New lowestCost founded, so clear old arrayList
			}
			else if (maintenanceCost == lowestCost) {
				duplicates.add(vehicle);
			}
		}
		
		if (duplicates.isEmpty()) { // Means only 1 Vehicle with lowestCost
			return vehicleWithLowestCost;
		}
		else { // Return random vehicle in list of Vehicles with same lowestCost
			Random randomNum = new Random(); // Create random instance
			int randomIndex = randomNum.nextInt(duplicates.size());
			return duplicates.get(randomIndex);
		}			
	}	
	
	
	
	//Fuel Efficiency
	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle with the highest fuel efficiency.
	 * If multiple vehicles have same maintenance cost, return all vehicles with same highest efficiency in ArrayList
	 * @param distance - double
	 * @param fuelPrice - double
	 * @return ArrayList<Vehicle>
	 */
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		double fuelEfficiency;
		double highestEfficiency = vehicleList.get(0).calculateFuelEfficiency(distance, fuelPrice);
		
		for (Vehicle vehicle : vehicleList) {
			fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
			if (fuelEfficiency > highestEfficiency) {
				highestEfficiency = fuelEfficiency;
				vehicles.clear(); // New highestEfficiency founded, so clear old arrayList
				vehicles.add(vehicle);
			}
			else if (fuelEfficiency == highestEfficiency) { // Add duplicates to vehicles list
				vehicles.add(vehicle);
			}
		}
		return vehicles;			
	}
	
	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle with the lowest fuel efficiency.
	 * If multiple vehicles have same maintenance cost, return all vehicles with same lowest efficiency in ArrayList
	 * @param distance - double
	 * @param fuelPrice - double
	 * @return ArrayList<Vehicle>
	 */
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		double fuelEfficiency;
		double lowestEfficiency = vehicleList.get(0).calculateFuelEfficiency(distance, fuelPrice);
		
		for (Vehicle vehicle : vehicleList) {
			fuelEfficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
			if (fuelEfficiency < lowestEfficiency) {
				lowestEfficiency = fuelEfficiency;
				vehicles.clear(); // New lowestEfficiency founded, so clear old arrayList
				vehicles.add(vehicle);
			}
			else if (fuelEfficiency == lowestEfficiency) { // Add duplicates to vehicles list
				vehicles.add(vehicle);
			}
		}
		return vehicles;			
	}
	
	/**
	 * Calculate the average/mean of the fuel efficiency of SUVs in the vehicle list. Use the isVehicleType(Vehicle v, Class clazz) method.
	 * If no SUVs exist in the list return -1.0 as an error code.
	 * @param distance
	 * @param fuelPrice
	 * @return double, -1.0 if no SUVs in list
	 */
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		ArrayList<SUV> suvs = new ArrayList<SUV>();
		double totalFuelEfficiency = 0.0;
		double avgFuelEfficiency;
		for (Vehicle vehicle : vehicleList) {
			if (isVehicleType(vehicle, SUV.class)) {
				suvs.add((SUV)vehicle);
				totalFuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
			}
		}
		if (suvs.isEmpty()) {
			return -1.0; // Error code
		}
		else {
			avgFuelEfficiency = totalFuelEfficiency / suvs.size();
			return avgFuelEfficiency;
		}
	}
		

}
