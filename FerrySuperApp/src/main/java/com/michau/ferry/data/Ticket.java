package com.michau.ferry.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tickets")
public class Ticket {

    @DatabaseField(generatedId = true)
    private int id;

    //    @DatabaseField(columnName = "passenger")
    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Passenger passenger;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Vehicle vehicle;

    @DatabaseField(foreign = true, foreignAutoCreate = true, foreignAutoRefresh = true)
    private Cargo cargo;

    @DatabaseField(columnName = "total_price")
    private Double totalPrice;

    public Ticket(Passenger passenger, Double totalPrice) {
        this.passenger = passenger;
        this.totalPrice = totalPrice;
    }

    public Ticket(Vehicle vehicle, Double totalPrice) {
        this.vehicle = vehicle;
        this.totalPrice = totalPrice;
    }

    public Ticket(Cargo cargo, Double totalPrice) {
        this.cargo = cargo;
        this.totalPrice = totalPrice;
    }

    public Ticket() {
    }
}
