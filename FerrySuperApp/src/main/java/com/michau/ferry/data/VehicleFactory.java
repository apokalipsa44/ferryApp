package com.michau.ferry.data;

import java.sql.SQLException;
import java.util.Scanner;

public class VehicleFactory  {
    public Vehicle vehicleFactory(int type, String licensePlate, Ticket ticket) {
        if (type == 1) {
            return new Vehicle(VehicleType.BIKE, licensePlate,ticket, 10.00) {
            };
        }
        if (type == 2) {
            return new Vehicle(VehicleType.CAR, licensePlate, ticket,20.00) {
            };
        }
        return null;
    }

    public Vehicle vehivleFactory(int type, String licensePlate,Ticket ticket, int input) {
        if (type == 3) {
            return new Vehicle(VehicleType.TRUCK, licensePlate,ticket, 10.00 * input) {
            };
        }
        if (type == 4) {
            return new Vehicle(VehicleType.BUS, licensePlate,ticket, 10.00 * input) {
            };
        }
        return null;
    }


    public void createVehicle(Ticket ticket) throws SQLException {
        System.out.println("Dodaję pojazd");
        System.out.println("Podaj typ: ");
        System.out.println("1. CAR / 2. BIKE / 3. BUS / 4. TRUCK");
        Scanner sc = new Scanner(System.in);
        String typeStr = sc.nextLine();
        int type = Integer.parseInt(typeStr);
        System.out.println("Podaj numer rejestracyjny: ");
        String licensePlate = sc.nextLine();
        Vehicle newVehicle;
        newVehicle = vehicleFactory(type, licensePlate, ticket);
//        daoPassengers.create(newPassenger);
        TicketGenerator ticketGenerator = new TicketGenerator();
        ticketGenerator.addVehicle(newVehicle, ticket);
    }
}

//        osobowy: 20zł
//        motor: 10zł
//        ciężarówka: 10zł za tonę
//        autobus: 5zł za metr