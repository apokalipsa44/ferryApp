package pl.exercise.ferry.vehicle;

import pl.exercise.ferry.pax.Passenger;

public abstract class Vehicle {
  private final VehicleType vehicleType;
  private final Passenger passenger;

  Vehicle(VehicleType vehicleType, Passenger passenger) {
    this.vehicleType = vehicleType;
    this.passenger = passenger;
  }
}
