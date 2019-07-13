package com.michau.ferry.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tickets")
public class Ticket {

    @DatabaseField(generatedId = true)
    private int id;
    private Passenger passenger;
    private Vehicle vehicle;
    private Cargo cargo;
    private Double totalPrice;
}
