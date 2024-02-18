package hw4;

public abstract class Vehicle {
	
	protected String brand;
	protected String make;
	
	protected long currentYear;
	
	protected long modelYear;
	protected double price;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;
	protected double mass;
	
	protected VehicleColor color;
	protected FuelType fuelType;
	protected StartMechanism startType;
	

	
	public Vehicle(String brand, String make, long modelYear, double price,
            double mileage, int cylinders, double gasTankCapacity,
            double mass, VehicleColor color, FuelType fuelType,
            StartMechanism startType) {
		this.brand = brand;
        this.make = make;
        this.modelYear = modelYear;
        this.price = price;
        this.mileage = mileage;
        this.cylinders = cylinders;
        this.gasTankCapacity = gasTankCapacity;
        this.mass = mass;
        this.color = color;
        this.fuelType = fuelType;
        this.startType = startType;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
	

	public long getCurrentYear() {
		return currentYear;
	}
	public void setCurrentYear(long currentYear) {
		this.currentYear = currentYear;
	}
	
	

	public long getModelYear() {
		return modelYear;
	}
	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}
	
	

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
	
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	
	

	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	
	

	public double getGasTankCapacity() {
		return gasTankCapacity;
	}
	public void setGasTankCapacity(double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}
	
	

	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}
	
	

	public VehicleColor getColor() {
		return color;
	}
	public void setColor(VehicleColor color) {
		this.color = color;
	}
	
	

	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
	

	public StartMechanism getStartType() {
		return startType;
	}
	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}
	

	
	
	
	public abstract double calculateMaintenanceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	public abstract void startEngine();

	

}
