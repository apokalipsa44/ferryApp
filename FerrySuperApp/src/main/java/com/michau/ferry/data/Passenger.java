package com.michau.ferry.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "passengers")
public class Passenger {
    public static final String TICKET_ID_FIELD_NAME = "ticket_id";

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "passenger_type")
    private PassengerType passengerType;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(foreign = true, foreignAutoRefresh = true, columnName = TICKET_ID_FIELD_NAME)
    private Ticket ticket;

    @DatabaseField(columnName = "price")
    private Double price;

    public Passenger(PassengerType passengerType, String name, Ticket ticket, Double price) {
        this.passengerType = passengerType;
        this.name = name;
        this.ticket = ticket;
        this.price = price;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(PassengerType passengerType) {
        this.passengerType = passengerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Passenger() {
    }
}
