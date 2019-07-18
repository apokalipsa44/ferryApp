package com.michau.ferry.data;

import java.sql.SQLException;
import java.util.Scanner;

import static com.michau.ferry.FerryMain.daoCruise;
import static com.michau.ferry.FerryMain.daoTickets;



public class VehicleFactory {


    public Vehicle vehicleFactory(int type, String licensePlate, Ticket ticket, int criuseId) throws SQLException {
        Scale scale = new Scale();
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        Cruise currentCruise = daoCruise.queryForId(criuseId);

        if (type == 1) {
//            currentCruise.setLoad(scale.getCurrentWeightCar());
            daoCruise.update(currentCruise);
            return new Vehicle(VehicleType.CAR, licensePlate, ticket, 10.00) {
            };
        }
        if (type == 2) {
//            currentCruise.setLoad(scale.getCurrentWeightBike());
            daoCruise.update(currentCruise);
            return new Vehicle(VehicleType.BIKE, licensePlate, ticket, 20.00) {
            };
        }
        if (type == 3) {
//            currentCruise.setLoad(scale.getCurrentWeighrTruck());
            daoCruise.update(currentCruise);
            return new Vehicle(VehicleType.TRUCK, licensePlate, ticket, 0.04 * scale.getCurrentWeighrTruck()) {
            };
        }
        return null;
    }

    public Vehicle vehicleFactory(int type, String licensePlate, Ticket ticket, int input, int cruseId) throws SQLException {
        Scale scale = new Scale();
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        Cruise currentCruise = daoCruise.queryForId(cruseId);

        if (type == 4) {
            currentCruise.setLoad(scale.getCurrentWeightBus());
            daoCruise.update(currentCruise);
            return new Vehicle(VehicleType.BUS, licensePlate, ticket, 10.00 * input) {
            };
        }
        return null;
    }


    public void createVehicle(Ticket ticket, int criuseId) throws SQLException {
//        if (ticket.isIsEmpty()){
//            ticket.setIsEmpty(false);
//        }
        System.out.println("Dodaję pojazd");
        System.out.println("Podaj typ: ");
        System.out.println("1. CAR / 2. BIKE / 3. TRUCK / 4. BUS");
        Scanner sc = new Scanner(System.in);
        String typeStr = sc.nextLine();
        int type = Integer.parseInt(typeStr);
        System.out.println("Podaj numer rejestracyjny: ");
        String licensePlate = sc.nextLine();

        if (type == 1 || type == 2 || type == 3) {
            Vehicle newVehicle;
            newVehicle = vehicleFactory(type, licensePlate, ticket, criuseId);
            TicketGenerator ticketGenerator = new TicketGenerator();
            ticketGenerator.addVehicle(newVehicle, ticket);
        }
        if (type == 4) {
            System.out.println("Podaj długość autobusu: ");
            String lengthStr = sc.nextLine();
            int length = Integer.parseInt(lengthStr);
            Vehicle newVehicle;
            newVehicle = vehicleFactory(type, licensePlate, ticket, length, criuseId);
            TicketGenerator ticketGenerator = new TicketGenerator();
            ticketGenerator.addVehicle(newVehicle, ticket);
        }

    }
}

//        osobowy: 20zł
//        motor: 10zł
//        ciężarówka: 10zł za tonę
//        autobus: 5zł za metr