package com.michau.ferry.menu;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.michau.ferry.data.*;
import com.michau.ferry.db.DbManager;
import org.apache.commons.lang3.math.NumberUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static com.michau.ferry.FerryMain.daoCruise;
import static com.michau.ferry.FerryMain.daoTickets;

public class MainScreen implements Screen {
    private final Scanner in = new Scanner(System.in);
    private final NumberUtils nu = new NumberUtils();
//    public static Dao<Passenger, Integer> daoPassengers;
//    public static Dao<Vehicle, Integer> daoVehicles;
//    public static Dao<Cargo, Integer> daoCargo;
//    public static Dao<Ticket, Integer> daoTickets;
//    public static Dao<Cruise, Integer> daoCruise;

    int cruiseId;

    public void interact(int cruiseIdParameter) throws SQLException {
        cruiseId=cruiseIdParameter;
        interact();
    }

    public void interact() throws SQLException {
        List<Ticket> emptyTickets = queryForEmptyTicket();
        emptyTickets.stream().forEach(e -> System.out.println(e.getId()));
        daoTickets.delete(emptyTickets);

        cruiseId = daoCruise.queryForAll().size();
        printLogo();
        System.out.println("Witamy w systemie twój rejs, wybierz akcję:");
        System.out.println("");


        System.out.println("1. Utworzenie nowego biletu");
        System.out.println("2. Odczyt zapisanych danych rejsu");
        System.out.println("3. Wyszukanie uczestnika rejsu");
        System.out.println("4. Utworzenie nowego rejsu");

        int firstResponse = in.nextInt();
        switch (firstResponse) {
            case 1: {
                Ticket ticket = new Ticket();
                ticket.setIsEmpty(true);
                daoTickets.create(ticket);
                addTicket(ticket, cruiseId);

                int currentTicketId = ticket.getId();
                NewTripMenu newTripScreen = new NewTripMenu();
                newTripScreen.interact(currentTicketId, cruiseId);
            }
            case 2: {
                TripDetailsMenu savedTripsScreen = new TripDetailsMenu();
                savedTripsScreen.interact();
            }
            case 3: {
                SearchScreen searchPassenger = new SearchScreen();
                searchPassenger.interact();
            }
            case 4: {
                cruiseId = generateNewCriuse();
            }
        }
    }

    private void addTicket(Ticket ticket, int criuseId) throws SQLException {
        Ticket currentTicket = daoTickets.queryForId(ticket.getId());
        Cruise currentCruise = daoCruise.queryForId(criuseId);
        currentTicket.setCruise(currentCruise);
        daoTickets.update(currentTicket);
//        QueryBuilder<Ticket, Integer> queryBuilder = daoTickets.queryBuilder();
//        queryBuilder.where().eq("cruise_id", criuseId);
//        PreparedQuery<Ticket> preparedQuery = queryBuilder.prepare();
//        List<Ticket> resultTickets = daoTickets.query(preparedQuery);
        List<Ticket> resultTickets = daoTickets.queryForEq("cruise_id", criuseId);
        resultTickets.add(currentTicket);
        daoCruise.update(currentCruise);
    }

    private int generateNewCriuse() throws SQLException {
        Cruise cruise = new Cruise();
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
        QueryBuilder<Ticket, Integer> queryBuilder = daoTickets.queryBuilder();
        queryBuilder.where().eq("is_empty", true);
        PreparedQuery<Ticket> preparedQuery = queryBuilder.prepare();
        List<Ticket> result = daoTickets.query(preparedQuery);
        return result;
    }

}
