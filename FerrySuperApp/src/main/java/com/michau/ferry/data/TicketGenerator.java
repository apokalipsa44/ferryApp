package com.michau.ferry.data;

import com.j256.ormlite.dao.ForeignCollection;
import java.sql.SQLException;


import static com.michau.ferry.menu.MainScreen.daoTickets;

public class TicketGenerator {

    public ForeignCollection<Passenger> addPassenger(Passenger passenger, Ticket ticket) throws SQLException {
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        ForeignCollection<Passenger> passengers =ticketResult.getPassengers();
        passengers.add(passenger);
//        ticket.getPassengers().stream().forEach(e->System.out.println(e.getName()));
        return passengers;
    }

    public ForeignCollection<Vehicle> addVehicle(Vehicle vehicle, Ticket ticket) throws SQLException {
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        ForeignCollection<Vehicle> vehicles = ticketResult.getVehicles();
        vehicles.add(vehicle);
        return vehicles;
    }

    public ForeignCollection<Cargo> addCargo(Cargo cargo, Ticket ticket) throws SQLException {
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        ForeignCollection<Cargo> cargos=ticketResult.getCargos();
        cargos.add(cargo);
        return cargos;
    }

    public void printCurrentTicket(Ticket ticket){
        System.out.println(ticket.getPassengers().toString());
        System.out.println(ticket.getVehicles().toString());
        System.out.println(ticket.getCargos().toString());
    }

}
