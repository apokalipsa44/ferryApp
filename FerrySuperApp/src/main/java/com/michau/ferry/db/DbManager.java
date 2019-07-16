package com.michau.ferry.db;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.michau.ferry.data.*;

import java.io.IOException;
import java.sql.SQLException;

public class DbManager {

    public static final String DATABASE_URL = "jdbc:sqlite:ferry.db";
//    public static final String DATABASE_URL = "jdbc:h2:./ferryDB";
    public static final Logger LOGGER = LoggerFactory.getLogger(DbManager.class);
    public static ConnectionSource connectionSource;

    public static void initDatabase() {
        createConnectionSource();
//        dropTable(); //zakomentuj, żeby nie kasować za każym razem tabel w bazie
        createTable();
        closeConnectionSource();
    }

    private static void createConnectionSource() {
        try {
            connectionSource = new JdbcConnectionSource(DATABASE_URL);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    public static ConnectionSource getConnectionSource() {
        if (connectionSource == null) {
            createConnectionSource();
        }
        return connectionSource;
    }

    public static void closeConnectionSource() {
        if (connectionSource != null) {
            try {
                connectionSource.close();
            } catch (IOException e) {
                LOGGER.warn(e.getMessage());
            }
        }
    }

    private static void createTable() {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Passenger.class);
            TableUtils.createTableIfNotExists(connectionSource, Vehicle.class);
            TableUtils.createTableIfNotExists(connectionSource, Cargo.class);
            TableUtils.createTableIfNotExists(connectionSource, Ticket.class);
            TableUtils.createTableIfNotExists(connectionSource, Cruise.class);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());
        }
    }

    private static void dropTable() {
        try {
            TableUtils.dropTable(connectionSource, Passenger.class, true);
            TableUtils.dropTable(connectionSource, Vehicle.class, true);
            TableUtils.dropTable(connectionSource, Cargo.class, true);
            TableUtils.dropTable(connectionSource, Ticket.class, true);
            TableUtils.dropTable(connectionSource, Cruise.class, true);
        } catch (SQLException e) {
            LOGGER.warn(e.getMessage());

        }

    }
}
