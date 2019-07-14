package com.michau.ferry.menu;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.michau.ferry.data.Cargo;
import com.michau.ferry.data.Passenger;
import com.michau.ferry.data.Ticket;
import com.michau.ferry.data.Vehicle;
import com.michau.ferry.db.DbManager;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.SQLException;
import java.util.List;
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

        List<Ticket> emptyTickets=queryForEmptyTicket();
        emptyTickets.stream().forEach(e-> System.out.println(e.getId()));


        System.out.println("Witamy w systemie twój rejs, wybierz akcję:");
        System.out.println("1. Utworzenie nowego biletu");
        System.out.println("2. Odczyt zapisanych danych rejsu");
        System.out.println("3. Wyszukanie uczestnika rejsu");
        int firstResponse = in.nextInt();
        switch (firstResponse){
            case 1:{
                Ticket ticket = new Ticket();
                ticket.setIsEmpty(false);
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

    private List<Ticket> queryForEmptyTicket() throws SQLException {
        QueryBuilder<Ticket, Integer> queryBuilder=daoTickets.queryBuilder();
        queryBuilder.where().eq("is_empty", true);
        PreparedQuery<Ticket> preparedQuery=queryBuilder.prepare();
        List<Ticket> result=daoTickets.query(preparedQuery);
        return result;
    }

}
