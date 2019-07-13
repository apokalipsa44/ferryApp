package com.michau.ferry;

import com.j256.ormlite.dao.Dao;
import com.michau.ferry.data.Cargo;
import com.michau.ferry.data.Passenger;
import com.michau.ferry.data.Ticket;
import com.michau.ferry.data.Vehicle;
import com.michau.ferry.db.DbManager;
import com.michau.ferry.menu.MainScreen;

import java.sql.SQLException;

public class FerryMain {
    public static void main(String[] args) throws SQLException {
        DbManager.initDatabase();
//        Dao<Passenger,Integer> daoPassengers;
//        Dao<Vehicle,Integer> daoVehicles;
//        Dao<Cargo,Integer> daoCargo;
//        Dao<Ticket,Integer> daoTickets;
        MainScreen mainScreen=new MainScreen();
        mainScreen.interact();

    }

}
