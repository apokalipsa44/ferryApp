package pl.exercise.ferry.vehicle;



public class VehilcleFactory {
    public Vehicle createVehicle(int type, String licensePlate) {
        if (type == 1) {
            return new Vehicle(VehicleType.BIKE, licensePlate) {
            };
        }if (type == 2) {
            return new Vehicle(VehicleType.CAR, licensePlate) {
            };
        }if (type == 3) {
            return new Vehicle(VehicleType.TRUCK, licensePlate) {
            };
        }if (type == 4) {
            return new Vehicle(VehicleType.BUS, licensePlate) {
            };
        }
        return null;
    }

}


