package com.michau.ferry.data;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;

import java.sql.SQLException;
import java.util.List;

import static com.michau.ferry.FerryMain.*;
import static com.michau.ferry.menu.MainScreen.*;

public class TicketGenerator {

    Scale scale =new Scale();

    public ForeignCollection<Passenger> addPassenger(Passenger passenger, Ticket ticket, int criuseId) throws SQLException {
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        Cruise currentCruise= daoCruise.queryForId(criuseId);
        ticketResult.setIsEmpty(false);
        currentCruise.setLoad(scale.getCurrentWeightPasserger());
        daoTickets.update(ticketResult);
        daoCruise.update(currentCruise);
        ForeignCollection<Passenger> passengers =ticketResult.getPassengers();
        passengers.add(passenger);
        return passengers;
    }

    public ForeignCollection<Vehicle> addVehicle(Vehicle vehicle, Ticket ticket) throws SQLException {
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        ticketResult.setIsEmpty(false);
        daoTickets.update(ticketResult);
        ForeignCollection<Vehicle> vehicles = ticketResult.getVehicles();
        vehicles.add(vehicle);
        return vehicles;
    }

    public ForeignCollection<Cargo> addCargo(Cargo cargo, Ticket ticket) throws SQLException {
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        ticketResult.setIsEmpty(false);
        daoTickets.update(ticketResult);
        ForeignCollection<Cargo> cargos=ticketResult.getCargos();
        cargos.add(cargo);
        return cargos;
    }

    public void printCurrentTicket(Ticket ticket) throws SQLException {
        collectPayment(queryForPassengers(ticket),queryForVehicles(ticket) ,queryForCargo(ticket));
    }

    private double queryForCargo(Ticket ticket) throws SQLException {
        QueryBuilder<Cargo,Integer> queryBuilder=daoCargo.queryBuilder();
        queryBuilder.where().eq("ticket", ticket.getId());
        PreparedQuery<Cargo> prepare = queryBuilder.prepare();
        List<Cargo> result=daoCargo.query(prepare);
        result.stream().forEach(e-> System.out.print(e.getDescryption()+" "));
        System.out.println(" ");
        double totalForVehicles=result.stream().mapToDouble(e->e.getPrice()).sum();
        System.out.println("Do zapłaty za ładunek:"+totalForVehicles+" $");
        System.out.println(" ");
        return totalForVehicles;
    }

    private double queryForVehicles(Ticket ticket) throws SQLException {
        QueryBuilder<Vehicle,Integer> queryBuilder=daoVehicles.queryBuilder();
        queryBuilder.where().eq("ticket", ticket.getId());
        PreparedQuery<Vehicle> prepare = queryBuilder.prepare();
        List<Vehicle> result=daoVehicles.query(prepare);
        result.stream().forEach(e-> System.out.print(e.getLicenssePlate()+" "));
        System.out.println("");
        double totalForCargo=result.stream().mapToDouble(e->e.getPrice()).sum();
        System.out.println("Do zapłaty za pojazdy:"+totalForCargo+" $");
        System.out.println(" ");
        return totalForCargo;
    }

    private double queryForPassengers(Ticket ticket) throws SQLException {
        QueryBuilder<Passenger,Integer> queryBuilder=daoPassengers.queryBuilder();
        queryBuilder.where().eq("ticket_id", ticket.getId());
        PreparedQuery<Passenger> prepare = queryBuilder.prepare();
        List<Passenger> result=daoPassengers.query(prepare);
        result.stream().forEach(e-> System.out.print(e.getName()+" "));
        double totalForPassengers=result.stream().mapToDouble(e->e.getPrice()).sum();
        System.out.println(" ");
        System.out.println("Do zapłaty za pasażerów:"+totalForPassengers+" $");
        System.out.println(" ");
        return totalForPassengers;
    }

    private void collectPayment(double totalForPassengers, double totalForVehicles, double totalForCargo){
        double total=totalForCargo+totalForPassengers+totalForVehicles;
        System.out.println("Do zapłaty: "+total+"$");
        System.out.println(" ");
    }

}
