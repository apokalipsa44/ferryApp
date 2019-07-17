package com.michau.ferry.menu;


import com.michau.ferry.data.*;
import java.sql.SQLException;
import java.util.Scanner;

import static com.michau.ferry.menu.MainScreen.daoTickets;

public class NewTripMenu implements Screen {
//    DbManager dbManager;
    private final Scanner sc = new Scanner(System.in);


    @Override
    public void interact() throws SQLException {

    }

    public void interact(int currrentTicketId, int criuseId) throws SQLException {
        System.out.println("Utworzenie nowego rejsu > Wybierz dalszą akcję:");
        System.out.println("1. Dodanie osoby do rejsu");
        System.out.println("2. Dodanie pojazdu do rejsu");
        System.out.println("3. Dodanie towaru do rejsu");
        System.out.println("4. Wydruk biletu");
        System.out.println("0. Powrót");

        NewTripMenu newTripMenu= new NewTripMenu();
        MainScreen mainScreen = new MainScreen();
        int response = sc.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Dodaj nowego pasażera");
                PassengerFactory passengerFactory = new PassengerFactory();
                passengerFactory.createPassenger(daoTickets.queryForId(currrentTicketId), criuseId);

                newTripMenu.interact(currrentTicketId, criuseId);
                break;

            }
            case 2: {
                System.out.println("Dodaj nowy pojazd");
                VehicleFactory vehicleFactory= new VehicleFactory();
                vehicleFactory.createVehicle(daoTickets.queryForId(currrentTicketId), criuseId);

                newTripMenu.interact(currrentTicketId, criuseId);
                break;
            }
            case 3: {
                System.out.println("Dodaj nowy towar");
                CargoFactory cargoFactory=new CargoFactory();
                cargoFactory.createCargo(daoTickets.queryForId(currrentTicketId), criuseId);

                newTripMenu.interact(currrentTicketId, criuseId);
                break;
            }
            case 4: {
                System.out.println("Wydruk biletu");
                TicketGenerator ticketGenerator= new TicketGenerator();
                ticketGenerator.printCurrentTicket(daoTickets.queryForId(currrentTicketId));

                newTripMenu.interact(currrentTicketId, criuseId);
                break;
            }
            case 0: {
                System.out.println("########################");

                mainScreen.interact();
                break;
            }

        }
    }
}
