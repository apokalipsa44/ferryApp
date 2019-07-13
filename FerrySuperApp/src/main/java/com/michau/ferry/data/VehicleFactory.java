package com.michau.ferry.data;

public class VehicleFactory {
    public Vehicle createVehicle(int type, String licensePlate) {
        if (type == 1) {
            return new Vehicle(VehicleType.BIKE, licensePlate, 10.00) {
            };
        }
        if (type == 2) {
            return new Vehicle(VehicleType.CAR, licensePlate, 20.00) {
            };
        }
        return null;
    }

    public Vehicle createVehicle(int type, String licensePlate, int input) {
        if (type == 3) {
            return new Vehicle(VehicleType.TRUCK, licensePlate, 10.00 * input) {
            };
        }
        if (type == 4) {
            return new Vehicle(VehicleType.BUS, licensePlate, 10.00 * input) {
            };
        }
        return null;
    }

}

//        osobowy: 20zł
//        motor: 10zł
//        ciężarówka: 10zł za tonę
//        autobus: 5zł za metr