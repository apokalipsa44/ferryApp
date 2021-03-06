package com.michau.ferry.data;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "vehicles")
public class Vehicle {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "vehicle_type")
    private VehicleType vehicleType;

    @DatabaseField(columnName = "license_plate")
    private String licenssePlate;

    @DatabaseField(columnName = "ticket", foreign = true)
    private Ticket ticket;


    @DatabaseField(columnName = "price")
    private Double price;

    public Vehicle(VehicleType vehicleType, String licenssePlate, Ticket ticket, Double price) {
        this.vehicleType = vehicleType;
        this.licenssePlate = licenssePlate;
        this.ticket = ticket;
        this.price = price;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicenssePlate() {
        return licenssePlate;
    }

    public void setLicenssePlate(String licenssePlate) {
        this.licenssePlate = licenssePlate;
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

    public Vehicle() {
    }
}
