package com.michau.ferry;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.michau.ferry.data.*;
import com.michau.ferry.db.DbManager;
import com.michau.ferry.menu.MainScreen;

import java.sql.SQLException;

public class FerryMain {
    public static Dao<Passenger, Integer> daoPassengers;
    public static Dao<Vehicle, Integer> daoVehicles;
    public static Dao<Cargo, Integer> daoCargo;
    public static Dao<Ticket, Integer> daoTickets;
    public static Dao<Cruise, Integer> daoCruise;

    public static void main(String[] args) throws SQLException {
        DbManager.initDatabase();
        daoPassengers = DaoManager.createDao(DbManager.connectionSource, Passenger.class);
        daoVehicles = DaoManager.createDao(DbManager.connectionSource, Vehicle.class);
        daoCargo = DaoManager.createDao(DbManager.connectionSource, Cargo.class);
        daoTickets = DaoManager.createDao(DbManager.connectionSource, Ticket.class);
        daoCruise = DaoManager.createDao(DbManager.connectionSource, Cruise.class);

        int cruiseId = 1;

        MainScreen mainScreen=new MainScreen();
        if(daoCruise.countOf()==0){
            Cruise cruise = new Cruise();
            daoCruise.create(cruise);
            cruiseId = daoCruise.queryForAll().size();
            mainScreen.interact(cruiseId);
        }

        mainScreen.interact();


    }

}
