package pl.exercise.ferry.vehicle;



public abstract class Vehicle {
  private final VehicleType vehicleType;
  private String licensePlate;

  public Vehicle(VehicleType vehicleType, String licensePlate) {
    this.vehicleType = vehicleType;
    this.licensePlate = licensePlate;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }



  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
            "vehicleType=" + vehicleType +
            ", licensePlate='" + licensePlate + '\'' +
            '}';
  }
}
