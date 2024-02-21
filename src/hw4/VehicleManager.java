package hw4;
import java.util.*;
import java.io.*;

public class VehicleManager {
	
	
	//Fields
	private static VehicleManager instance;
	private final static String inventoryFilePath = "files/vehicleList.csv";
	ArrayList<Vehicle> vehicleList = new ArrayList<>();
	
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
	
	
	
	
	
	
	
	
	//Displays
	public void displayAllCarInformation() {
		
		
	}
	
	
	public void displayAllTruckInformation() {
		
	}
	
	public void displayAllSUVInformation() {
		
	}
	
	
	public void displayAllMotorBikeInformation() {
		
	}
	
	
	public void displayVehicleInformation(Vehicle v) {
		
	}
	
	
	public void displayAllVehicleInformation() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//General
	
	public boolean removeVehicle(Vehicle vehicle) {
		
	}
	
	
	public boolean addVehicle(Vehicle vehicle) {
		
	}
	
	
	
	private boolean isVehicleType(Vehicle v, Class clazz) {
			
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Vehicle Search
	public int getNumberOfVehichlesByType(Class clazz){
		
	}
	
	
	
	
	
	
	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle with the highest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the vehicles (Use the Random class for random selection).
	 * @param distance
	 * @return Vehicle
	 */
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		
	}
	
	/**
	 * Calculate the maintenance cost for each vehicle in the vehicle list and return the vehicle with the lowest maintenance cost.
	 * If multiple vehicles have the same maintenance cost, randomly return one of the vehicles (Use the Random class for random selection).
	 * @param distance
	 * @return Vehicle
	 */
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance){
			
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
			
	}
	
	/**
	 * Calculate the fuel efficiencies for each vehicle in the vehicle list and return the vehicle with the lowest fuel efficiency.
	 * If multiple vehicles have same maintenance cost, return all vehicles with same lowest efficiency in ArrayList
	 * @param distance - double
	 * @param fuelPrice - double
	 * @return ArrayList<Vehicle>
	 */
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
			
	}
	
	/**
	 * Calculate the average/mean of the fuel efficiency of SUVs in the vehicle list. Use the isVehicleType(Vehicle v, Class clazz) method.
	 * If no SUVs exist in the list return -1.0 as an error code.
	 * @param distance
	 * @param fuelPrice
	 * @return
	 */
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
			
	}
		

}
