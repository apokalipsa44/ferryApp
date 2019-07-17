package com.michau.ferry.menu;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.michau.ferry.data.*;
import com.michau.ferry.db.DbManager;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainScreen implements Screen {
    private final Scanner in = new Scanner(System.in);
    private final NumberUtils nu = new NumberUtils();

    public static Dao<Passenger,Integer> daoPassengers;
    public static Dao<Vehicle,Integer> daoVehicles;
    public static Dao<Cargo,Integer> daoCargo;
    public static Dao<Ticket,Integer> daoTickets;
    public static Dao<Cruise,Integer> daoCruise;
    int cruiseId;
    public void interact() throws SQLException {

        daoPassengers = DaoManager.createDao(DbManager.connectionSource, Passenger.class);
        daoVehicles = DaoManager.createDao(DbManager.connectionSource, Vehicle.class);
        daoCargo = DaoManager.createDao(DbManager.connectionSource, Cargo.class);
        daoTickets = DaoManager.createDao(DbManager.connectionSource, Ticket.class);
        daoCruise = DaoManager.createDao(DbManager.connectionSource, Cruise.class);

        List<Ticket> emptyTickets=queryForEmptyTicket();
        emptyTickets.stream().forEach(e-> System.out.println(e.getId()));
        daoTickets.delete(emptyTickets);
        printLogo();
        System.out.println("Witamy w systemie twój rejs, wybierz akcję:");
        System.out.println("");
        System.out.println("Czy rozpoczynać nowy rejs?  [T/N]");
        String response=in.nextLine();
        if(response.equalsIgnoreCase("T")) {
            cruiseId = generateNewCriuse();
        }

        System.out.println("1. Utworzenie nowego biletu");
        System.out.println("2. Odczyt zapisanych danych rejsu");
        System.out.println("3. Wyszukanie uczestnika rejsu");

        int firstResponse = in.nextInt();
        switch (firstResponse){
            case 1:{
                Ticket ticket = new Ticket();
                ticket.setIsEmpty(true);
                daoTickets.create(ticket);
                addTicket(ticket, cruiseId);

                int currentTicketId=ticket.getId();
                NewTripMenu newTripScreen= new NewTripMenu();
                newTripScreen.interact(currentTicketId, cruiseId);
            }
            case 2:{
                TripDetailsMenu savedTripsScreen=new TripDetailsMenu();
                savedTripsScreen.interact();
            }
            case 3:{
                SearchScreen searchPassenger=new SearchScreen();
                searchPassenger.interact();
            }
        }
    }

    private void addTicket(Ticket ticket, int criuseId) throws SQLException {
        Ticket currentTicket = daoTickets.queryForId(ticket.getId());
        Cruise currentCruise= daoCruise.queryForId(criuseId);
//        currentTicket.setCruise(currentCruise);
//        daoTickets.update(currentTicket);
        ForeignCollection<Ticket>tickets= currentCruise.getTickets();
        tickets.add(currentTicket);
        daoTickets.update((PreparedUpdate<Ticket>) tickets);
        daoCruise.update(currentCruise);
    }

    private int generateNewCriuse() throws SQLException {
        Cruise cruise= new Cruise();
        daoCruise.create(cruise);
         return cruise.getId();
    }

    private void printLogo() {
        System.out.println(" @@@@@@   @@@  @@@  @@@@@@@   @@@@@@@@  @@@@@@@         @@@@@@@@  @@@@@@@@  @@@@@@@   @@@@@@@   @@@ @@@          @@@@@@   @@@@@@@ ");
        System.out.println("@@@@@@@   @@@  @@@  @@@@@@@@  @@@@@@@@  @@@@@@@@        @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@ @@@         @@@@@@@   @@@@@@@@");
        System.out.println("!@@       @@!  @@@  @@!  @@@  @@!       @@!  @@@        @@!       @@!       @@!  @@@  @@!  @@@  @@! !@@              @@@  @@!  @@@");
        System.out.println("!!@@!!    @!@  !@!  @!@@!@!   @!!!:!    @!@!!@!         @!!!:!    @!!!:!    @!@!!@!   @!@!!@!    !@!@!           @!@!!@   @!@  !@!");
        System.out.println(" !!@!!!   !@!  !!!  !!@!!!    !!!!!:    !!@!@!          !!!!!:    !!!!!:    !!@!@!    !!@!@!      @!!!           !!@!@!   !@!  !!!");
        System.out.println("     !:!  !!:  !!!  !!:       !!:       !!: :!!         !!:       !!:       !!: :!!   !!: :!!     !!:                !!:  !!:  !!!");
        System.out.println("    !:!   :!:  !:!  :!:       :!:       :!:  !:!        :!:       :!:       :!:  !:!  :!:  !:!    :!:                :!:  :!:  !:!");
        System.out.println("::::::     :::::::  ::        :: ::::   ::   :::        ::        :: ::::   ::   :::  ::   :::    ::            :: ::::   :::: ::");
        System.out.println(":: ::      : :  :   :         : :: ::   :    : :        :         : :: ::   :    : :  :    : :    :              : : :    :: : : ");
        System.out.println("");
    }

    @Override
    public void interact(int input, int input2) throws SQLException {

    }

    private List<Ticket> queryForEmptyTicket() throws SQLException {
        QueryBuilder<Ticket, Integer> queryBuilder=daoTickets.queryBuilder();
        queryBuilder.where().eq("is_empty", true);
        PreparedQuery<Ticket> preparedQuery=queryBuilder.prepare();
        List<Ticket> result=daoTickets.query(preparedQuery);
        return result;
    }

}
