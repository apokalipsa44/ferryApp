package com.michau.ferry.data;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "tickets")
public class Ticket {

    @DatabaseField(generatedId = true)
    private int id;

    @ForeignCollectionField
    private ForeignCollection<Passenger> passengers;

    @ForeignCollectionField
    private ForeignCollection<Vehicle> vehicles;

    @ForeignCollectionField
    private ForeignCollection<Cargo> cargos;

    @DatabaseField(columnName = "total_price")
    private Double totalPrice;

    public int getId() {
        return id;
    }

    public ForeignCollection<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ForeignCollection<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ForeignCollection<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ForeignCollection<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public ForeignCollection<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(ForeignCollection<Cargo> cargos) {
        this.cargos = cargos;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Ticket() {
    }
}
