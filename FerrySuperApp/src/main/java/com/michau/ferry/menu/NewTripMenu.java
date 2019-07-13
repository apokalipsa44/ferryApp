package com.michau.ferry.menu;


import com.j256.ormlite.dao.DaoManager;
import com.michau.ferry.data.Passenger;
import com.michau.ferry.data.PassengerFactory;
import com.michau.ferry.db.DbManager;

import java.sql.SQLException;
import java.util.Scanner;

public class NewTripMenu implements Screen {
    DbManager dbManager;
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
            case 1:{
                System.out.println("Dodaj nowego pasażera");
                PassengerFactory passengerFactory=new PassengerFactory();
                MainScreen.daoPassengers = DaoManager.createDao(DbManager.connectionSource, Passenger.class);
                Passenger passenger = passengerFactory.create();
                MainScreen mainScreen=new MainScreen();
                mainScreen.daoPassengers.create(passenger);
            }
            case 2:{
                System.out.println("Dodaj nowy pojazd");
            }
            case 3:{
                System.out.println("Dodaj nowy towar");
            }
            case 4:{
                System.out.println("Wydruk biletu");
            }
            case 5:{
                System.out.println("########################");
                MainScreen mainScreen= new MainScreen();
                mainScreen.interact();
            }

        }
    }
}
