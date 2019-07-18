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

    @DatabaseField(columnName = "is_empty")
    private boolean isEmpty;

    @DatabaseField(foreign = true, columnName = "cruise_id", foreignAutoRefresh = true)
    private Cruise cruise;

    @DatabaseField(columnName = "currentWeight")
    private Integer currentWeight;

    public Ticket(ForeignCollection<Passenger> passengers, ForeignCollection<Vehicle> vehicles, ForeignCollection<Cargo> cargos, boolean isEmpty, Cruise cruise, Integer currentWeight) {
        this.passengers = passengers;
        this.vehicles = vehicles;
        this.cargos = cargos;
        this.isEmpty = isEmpty;
        this.cruise = cruise;
        this.currentWeight = currentWeight;
    }

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

    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight =this.currentWeight+ currentWeight;
    }

    public Ticket() {
    }
}
