package hw4;

public class Truck extends Vehicle {
	
	public Truck(String brand, String make, long modelYear, double price,
            double mileage, int cylinders, double gasTankCapacity,
            double mass, VehicleColor color, FuelType fuelType,
            StartMechanism startType) {
		super(brand, make, modelYear, price, mileage, cylinders, gasTankCapacity,
	              mass, color, fuelType, startType);
	}

	@Override
	public String toString() {
		return "Truck [brand=" + brand + ", make=" + make + ", currentYear=" + currentYear + ", modelYear=" + modelYear
				+ ", price=" + price + ", mileage=" + mileage + ", cylinders=" + cylinders + ", gasTankCapacity="
				+ gasTankCapacity + ", mass=" + mass + ", color=" + color + ", fuelType=" + fuelType + ", startType="
				+ startType + "]";
	}
	
	@Override
    public String toCSVString() {
        return String.format("Truck,%s,%s,%d,%.2f,%s,%s,%.2f,%.2f,%d,%.2f,%s",
                getBrand(), getMake(), getModelYear(), getPrice(), getColor(), getFuelType(), 
                getMileage(), getMass(), getCylinders(), getGasTankCapacity(), getStartType());
    }

	@Override
	public double calculateMaintenanceCost(double distance) {
		double maintenanceCost;
		maintenanceCost = distance * super.mass * (currentYear-modelYear)*cylinders*0.002;
		return maintenanceCost;
	}

	@Override
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency;
		fuelEfficiency = (cylinders*gasTankCapacity*fuelPrice)/(distance*0.1);
		return fuelEfficiency;
	}

	@Override
	public void startEngine() {
		System.out.println(""+super.startType);

	}

}
