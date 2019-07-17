package com.michau.ferry.data;

import java.sql.SQLException;
import java.util.Scanner;

import static com.michau.ferry.menu.MainScreen.daoCruise;
import static com.michau.ferry.menu.MainScreen.daoTickets;

public class CargoFactory {
    public Cargo cargoFactory(int type, String content, Ticket ticket, int criuseId) throws SQLException {
        Scale scale= new Scale();
        Ticket ticketResult = daoTickets.queryForId(ticket.getId());
        Cruise currentCruise = daoCruise.queryForId(criuseId);
        if (type == 1) {
            currentCruise.setLoad(scale.getCurrentWeightBigCargo());
            daoCruise.update(currentCruise);
            return new Cargo(CargoType.BIG, content, ticket, 36.52);
        }
        if (type == 2) {
            currentCruise.setLoad(scale.getCurrentWeightSmallCargo());
            daoCruise.update(currentCruise);
            return new Cargo(CargoType.SMALL, content, ticket, 4.25);
        }
        if (type == 3) {
            currentCruise.setLoad(scale.getCurrentWeightPalleteCargo());
            daoCruise.update(currentCruise);
            return new Cargo(CargoType.PALLETE, content, ticket, 124.00);
        }
        return null;
    }


    public void createCargo(Ticket ticket, int criuseId) throws SQLException {
        if (ticket.isIsEmpty()){
            ticket.setIsEmpty(false);
        }
        System.out.println("Dodaje  towar");
        System.out.println("Wybierz rodzaj towaru: ");
        System.out.println("1. BIG / 2. SMALL / 3. PALLETE ");
        Scanner sc = new Scanner(System.in);
        String typeStr = sc.nextLine();
        int type = Integer.parseInt(typeStr);
        System.out.println("Podaj zawartość");
        String content = sc.nextLine();
        Cargo newCargo = cargoFactory(type, content, ticket,criuseId);
        TicketGenerator ticketGenerator=new TicketGenerator();
        ticketGenerator.addCargo(newCargo,ticket);

    }
}
