package pl.exercise.ferry.ticket;

import pl.exercise.ferry.Cargo.Cargo;
import pl.exercise.ferry.pax.Passenger;
import pl.exercise.ferry.vehicle.Vehicle;

import java.math.BigDecimal;

public class TicketImpl implements Ticket {
    private Passenger passenger;
    private Vehicle vehicle;
    private Cargo cargo;
    private TicketType ticketType;

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }


    public TicketImpl(Passenger passenger) {
        this.passenger = passenger;

    }

    public TicketImpl(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public TicketImpl(Cargo cargo) {
        this.cargo = cargo;
    }

    public TicketImpl() {

    }


    @Override
    public BigDecimal getPrice() {
        System.out.println("tu bedzie cena");
        return null;
    }

    @Override
    public String toString() {
        return "TicketImpl{" +
                "passenger=" + passenger +
                ", vehicle=" + vehicle +
                ", cargo=" + cargo +
                '}';
    }
}

