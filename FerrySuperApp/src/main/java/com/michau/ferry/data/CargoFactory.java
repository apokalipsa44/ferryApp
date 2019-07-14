package com.michau.ferry.data;

import java.sql.SQLException;
import java.util.Scanner;

public class CargoFactory {
    public Cargo cargoFactory(int type, String content, Ticket ticket) {
        if (type == 1) {
            return new Cargo(CargoType.BIG, content, ticket, 36.52);
        }
        if (type == 2) {
            return new Cargo(CargoType.SMALL, content, ticket, 4.25);
        }
        if (type == 3) {
            return new Cargo(CargoType.PALLETE, content, ticket, 124.00);
        }
        return null;
    }


    public void createCargo(Ticket ticket) throws SQLException {
        System.out.println("Dodaje  towar");
        System.out.println("Wybierz rodzaj towaru: ");
        System.out.println("1. BIG / 2. SMALL / 3. PALLETE ");
        Scanner sc = new Scanner(System.in);
        String typeStr = sc.nextLine();
        int type = Integer.parseInt(typeStr);
        System.out.println("Podaj zawartość");
        String content = sc.nextLine();
        Cargo newCargo = cargoFactory(type, content, ticket);
        TicketGenerator ticketGenerator=new TicketGenerator();
        ticketGenerator.addCargo(newCargo,ticket);

    }
}
