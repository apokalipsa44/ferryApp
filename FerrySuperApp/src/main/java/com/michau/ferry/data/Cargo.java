package com.michau.ferry.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "cargo")
public class Cargo {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "cargo_type")
    private CargoType cargoType;

    @DatabaseField(columnName = "cargo_descryption")
    private String descryption;

    @DatabaseField(columnName = "ticket", foreign = true)
    private Ticket ticket;


    @DatabaseField(columnName = "price")
    private Double price;

    public Cargo(CargoType cargoType, String descryption, Ticket ticket, Double price) {
        this.cargoType = cargoType;
        this.descryption = descryption;
        this.ticket = ticket;
        this.price = price;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
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

    public Cargo() {
    }
}
