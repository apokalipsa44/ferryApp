package com.michau.ferry.menu;


import com.j256.ormlite.dao.DaoManager;
import com.michau.ferry.data.*;
import com.michau.ferry.db.DbManager;

import java.sql.SQLException;
import java.util.Scanner;

import static com.michau.ferry.menu.MainScreen.daoTickets;

public class NewTripMenu implements Screen {
//    DbManager dbManager;
    private final Scanner sc = new Scanner(System.in);

    public void interact() throws SQLException {
        System.out.println("Utworzenie nowego rejsu > Wybierz dalszą akkcję:");
        System.out.println("1. Dodanie osoby do rejsu");
        System.out.println("2. Dodanie pojazdu do rejsu");
        System.out.println("3. Dodanie towaru do rejsu");
        System.out.println("4. Wydruk biletu");
        System.out.println("0. Powrót");


        int response = sc.nextInt();

        switch (response) {
            case 1: {
                System.out.println("Dodaj nowego pasażera");
                PassengerFactory passengerFactory = new PassengerFactory();
                passengerFactory.createPassenger(daoTickets.queryForId((int) daoTickets.countOf()));
                NewTripMenu newTripMenu= new NewTripMenu();
                newTripMenu.interact();
                break;

            }
            case 2: {
                System.out.println("Dodaj nowy pojazd");
                VehicleFactory vehicleFactory= new VehicleFactory();
                vehicleFactory.createVehicle(daoTickets.queryForId((int) daoTickets.countOf()));
                break;
            }
            case 3: {
                System.out.println("Dodaj nowy towar");
                CargoFactory cargoFactory=new CargoFactory();
                cargoFactory.createCargo(daoTickets.queryForId((int) daoTickets.countOf()));
                break;
            }
            case 4: {
                System.out.println("Wydruk biletu");
                TicketGenerator ticketGenerator= new TicketGenerator();
                ticketGenerator.printCurrentTicket(daoTickets.queryForId(2));
                break;
            }
            case 5: {
                System.out.println("########################");
                MainScreen mainScreen = new MainScreen();
                mainScreen.interact();
                break;
            }

        }
    }
}
