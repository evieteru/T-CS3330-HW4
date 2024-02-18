package hw4;

public abstract class Vehicle {
	
	protected String brand;
	protected String make;
	
	protected long modelYear;
	protected double price;
	protected double mileage;
	protected int cylinders;
	protected double gasTankCapacity;
	
	protected VehicleColor color;
	protected FuelType fuelType;
	protected StartMechanism startType;
	
	
	public abstract double calculateMaintenanceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	public abstract void startEngine();
	

}
