package com.michau.ferry.menu;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.michau.ferry.data.Cargo;
import com.michau.ferry.data.Passenger;
import com.michau.ferry.data.Ticket;
import com.michau.ferry.data.Vehicle;
import com.michau.ferry.db.DbManager;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class MainScreen implements Screen {
    private final Scanner in = new Scanner(System.in);
    private final NumberUtils nu = new NumberUtils();

    public static Dao<Passenger,Integer> daoPassengers;
    public static Dao<Vehicle,Integer> daoVehicles;
    public static Dao<Cargo,Integer> daoCargo;
    public static Dao<Ticket,Integer> daoTickets;
    public void interact() throws SQLException {
        daoPassengers = DaoManager.createDao(DbManager.connectionSource, Passenger.class);
        daoVehicles = DaoManager.createDao(DbManager.connectionSource, Vehicle.class);
        daoCargo = DaoManager.createDao(DbManager.connectionSource, Cargo.class);
        daoTickets = DaoManager.createDao(DbManager.connectionSource, Ticket.class);
        System.out.println("Witamy w systemie twój rejs, wybierz akcję:");
        System.out.println("1. Utworzenie nowego biletu");
        System.out.println("2. Odczyt zapisanych danych rejsu");
        System.out.println("3. Wyszukanie uczestnika rejsu");
        int firstResponse = in.nextInt();
        switch (firstResponse){
            case 1:{
                Ticket ticket = new Ticket();
                daoTickets.create(ticket);
                NewTripMenu newTripScreen= new NewTripMenu();
                newTripScreen.interact();
            }
            case 2:{
                TripDetailsMenu savedTripsScreen=new TripDetailsMenu();
                savedTripsScreen.interact();
            }
            case 3:{
                SearchScreen searchPassenger=new SearchScreen();
                searchPassenger.interact();
            }
        }
    }

}
