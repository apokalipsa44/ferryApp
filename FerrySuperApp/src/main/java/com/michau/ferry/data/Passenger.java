package com.michau.ferry.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "passengers")
public class Passenger {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "passenger_type")
    private PassengerType passengerType;

    @DatabaseField(columnName = "name")
    private String name;

    @DatabaseField(columnName = "price")
    private Double price;

    public Passenger(PassengerType passengerType, String name, Double price) {
        this.passengerType = passengerType;
        this.name = name;
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

    public Passenger() {
    }
}
