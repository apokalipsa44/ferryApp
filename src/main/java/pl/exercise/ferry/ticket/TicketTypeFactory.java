package pl.exercise.ferry.ticket;

import pl.exercise.ferry.Cargo.Cargo;
import pl.exercise.ferry.pax.Passenger;
import pl.exercise.ferry.vehicle.Vehicle;

public class TicketTypeFactory {

    public TicketImpl printTicket(TicketType ticketType, Passenger passenger, Cargo cargo, Vehicle vehicle) {
        if(ticketType==TicketType.PERSON) {
            return new TicketImpl(passenger);
        }
        if (ticketType==TicketType.CARGO) {
            return new TicketImpl(cargo);
        }
        if (ticketType==TicketType.VEHICLE) {
            return new TicketImpl(vehicle);
        }
        return null;
    }
}
