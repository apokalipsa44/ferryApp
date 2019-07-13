package pl.exercise.ferry.screen;

import pl.exercise.ferry.Cargo.Cargo;
import pl.exercise.ferry.Cargo.CargoFactory;
import pl.exercise.ferry.pax.Passenger;
import pl.exercise.ferry.pax.PassengerFactory;
import pl.exercise.ferry.ticket.TicketImpl;
import pl.exercise.ferry.ticket.TicketType;
import pl.exercise.ferry.ticket.TicketTypeFactory;
import pl.exercise.ferry.vehicle.Vehicle;
import pl.exercise.ferry.vehicle.VehilcleFactory;

import java.util.Scanner;


public class NewTripScreen  implements Screen{

    static Passenger passenger;
    static Vehicle vehicle;
    static Cargo cargo;
    static TicketImpl ticket = new TicketImpl();
    private final Scanner sc = new Scanner(System.in);
    public void interact(){
        System.out.println("Utworzenie nowego rejsu > Wybierz dalszą akkcję:");
        System.out.println("1. Dodanie osoby do rejsu");
        System.out.println("2. Dodanie pojazdu do rejsu");
        System.out.println("3. Dodanie towaru do rejsu");
        System.out.println("4. Wydruk biletu");
        System.out.println("0. Powrót");

        int response = sc.nextInt();

        switch (response){
            case 1:
                System.out.println("dodaje osobe");
                System.out.println("Podaj wiek: ");
                Scanner sc1=new Scanner(System.in);
                String ageStr =sc1.nextLine();
                int age=Integer.parseInt(ageStr);
                System.out.println("Podaj imię: ");
//                String blank=sc1.nextLine();
                String name=sc1.nextLine();
                System.out.println("");
                PassengerFactory passengerFactory = new PassengerFactory();
                passenger=passengerFactory.createPassenger(name,age);
                ticket.setTicketType(TicketType.PERSON);
                System.out.println(passenger.toString());
                System.out.println("");
                this.interact();

            case 2:
                System.out.println("dodaje pojazd");
                System.out.println("Wybierz rodzaj pojazdu: ");
                System.out.println("1. CAR / 2. BIKE / 3. BUS / 4. TRUCK");
                Scanner sc2=new Scanner(System.in);
                String vechTypeStr =sc2.nextLine();
                int vechType=Integer.parseInt(vechTypeStr);
                System.out.println("Podaj numer rejestracyjny: ");
//                String blank=sc1.nextLine();
                String licensePlate=sc2.nextLine();
                System.out.println("");
                VehilcleFactory vehilcleFactory=new VehilcleFactory();
                vehicle=vehilcleFactory.createVehicle(vechType, licensePlate);
                ticket.setTicketType(TicketType.VEHICLE);
                System.out.println(vehicle.toString());
                System.out.println("");
                this.interact();
            case 3:
                System.out.println("Dodaje  towar");
                System.out.println("Wybierz rodzaj towaru: ");
                System.out.println("1. BIG / 2. SMALL / 3. PALLETE ");
                Scanner sc3 = new Scanner(System.in);
                String cargoTypeeString = sc3.nextLine();
                int cargoType=Integer.parseInt(cargoTypeeString);
                System.out.println("Podaj zawartość");
                String content = sc3.nextLine();
                CargoFactory cargoFactory= new CargoFactory();
                cargo=cargoFactory.createCargo(cargoType,content);
                ticket.setTicketType(TicketType.CARGO);
                System.out.println(cargo.toString());
                System.out.println("");
                this.interact();

            case 4:
                System.out.println("drukuje bilet");
                TicketTypeFactory ticketTypeFactory=new TicketTypeFactory();
                ticket=ticketTypeFactory.printTicket(ticket.getTicketType(), passenger, cargo, vehicle);

                System.out.println(ticket.getPrice());
                System.out.println(ticket.toString());
                System.out.println("");
                System.out.println("");
            case 0:
                MainScreen mainScreen = new MainScreen();
                mainScreen.interact();
        }
    }

}
