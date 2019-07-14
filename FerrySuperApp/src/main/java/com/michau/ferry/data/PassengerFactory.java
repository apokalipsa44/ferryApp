package com.michau.ferry.data;

import java.sql.SQLException;
import java.util.Scanner;

public class PassengerFactory {

    public Passenger passengerFactory(String name, int age, Ticket ticket) {
        if (age <= 3) {
            return new Passenger(PassengerType.CHILD, name, ticket, 0.00);
        }
        if (age > 3 && age <= 18) {
            return new Passenger(PassengerType.YOUNG, name, ticket, 5.00);
        }
        if (age > 18 && age <= 70) {
            return new Passenger(PassengerType.ADULT, name, ticket, 10.00);
        }
        if (age >= 70) {
            return new Passenger(PassengerType.SENIOR, name, ticket, 5.00);
        }
        return null;
    }

    public void createPassenger(Ticket ticket) throws SQLException {
        if (ticket.isIsEmpty()){
            ticket.setIsEmpty(false);
        }
        System.out.println("dodaje osobe");
        System.out.println("Podaj wiek: ");
        Scanner sc = new Scanner(System.in);
        String ageStr = sc.nextLine();
        int age = Integer.parseInt(ageStr);
        System.out.println("Podaj imię: ");
        String name = sc.nextLine();
        Passenger newPassenger;
        newPassenger = passengerFactory(name, age, ticket);
        TicketGenerator ticketGenerator = new TicketGenerator();
        ticketGenerator.addPassenger(newPassenger, ticket);
    }


}
//do 3 lat: 0zł child
//        od 3 do 18 lat: 5zł young
//        od 18 do 70 lat: 10zł adult
//        powyżej 70 lat: 5zł senior
