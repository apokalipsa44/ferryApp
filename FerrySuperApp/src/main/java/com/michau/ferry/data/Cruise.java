package com.michau.ferry.data;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "cruise")
public class Cruise {

    private final Integer FERRY_MAX_LOAD = 150000;

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "date")
    private Date date;

    @DatabaseField(columnName = "captain")
    private String captain;

    @DatabaseField(columnName = "load")
    private Integer load;

    @ForeignCollectionField
    private ForeignCollection<Ticket> tickets;


    public Cruise() {
    }

    public Cruise(Date date, String captain, Integer load, ForeignCollection<Ticket> tickets) {
        this.date = date;
        this.captain = captain;
        this.load = load;
        this.tickets = tickets;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public Integer getLoad() {
        return load;
    }

    public void setLoad(Integer load) {
        this.load = load;
    }

    public ForeignCollection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ForeignCollection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
