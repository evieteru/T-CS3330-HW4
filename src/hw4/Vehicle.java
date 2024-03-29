package hw4;
import java.time.LocalDate;
import java.util.Objects;


public abstract class Vehicle {

	protected String brand;
	protected String make;


	protected long modelYear;
	protected double price;
	protected double mileage;
	protected double mass;
	protected int cylinders;
	protected double gasTankCapacity;


	protected VehicleColor color;
	protected FuelType fuelType;
	protected StartMechanism startType;


	public static long currentYear = LocalDate.now().getYear();;




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


	public String getMake() {
		return make;
	}



	public long getCurrentYear() {
		return currentYear;
	}



	public long getModelYear() {
		return modelYear;
	}



	public double getPrice() {
		return price;
	}


	public double getMileage() {
		return mileage;
	}



	public int getCylinders() {
		return cylinders;
	}


	public double getGasTankCapacity() {
		return gasTankCapacity;
	}


	public double getMass() {
		return mass;
	}


	public VehicleColor getColor() {
		return color;
	}



	public FuelType getFuelType() {
		return fuelType;
	}



	public StartMechanism getStartType() {
		return startType;
	}


	@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        
     
        return Objects.equals(this.brand, other.brand) &&
               Objects.equals(this.make, other.make) &&
               Objects.equals(this.modelYear, other.modelYear);
    }



	public abstract double calculateMaintenanceCost(double distance);
	public abstract double calculateFuelEfficiency(double distance, double fuelPrice);
	public abstract void startEngine();
	public abstract String toCSVString();



}
