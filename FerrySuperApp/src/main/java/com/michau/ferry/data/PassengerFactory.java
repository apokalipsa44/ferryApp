package com.michau.ferry.data;

import java.util.Scanner;

public class PassengerFactory implements TicketCreate {

    public Passenger createPassenger(String name, int age) {
        if (age <= 3) {
            return new Passenger(PassengerType.CHILD, name, 0.00);
        }
        if (age > 3 && age <= 18) {
            return new Passenger(PassengerType.YOUNG, name, 5.00);
        }
        if (age > 18 && age <= 70) {
            return new Passenger(PassengerType.ADULT, name, 10.00);
        }
        if (age >= 70) {
            return new Passenger(PassengerType.SENIOR, name, 5.00);
        }
        return null;
    }

    @Override
    public Passenger create() {
        System.out.println("dodaje osobe");
        System.out.println("Podaj wiek: ");
        Scanner sc=new Scanner(System.in);
        String ageStr =sc.nextLine();
        int age=Integer.parseInt(ageStr);
        System.out.println("Podaj imię: ");
        //                String blank=sc1.nextLine();
        String name=sc.nextLine();

        return createPassenger(name, age);
    }
}
//do 3 lat: 0zł child
//        od 3 do 18 lat: 5zł young
//        od 18 do 70 lat: 10zł adult
//        powyżej 70 lat: 5zł senior
