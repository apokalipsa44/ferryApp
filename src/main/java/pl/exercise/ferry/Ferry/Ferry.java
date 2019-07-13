package pl.exercise.ferry.Ferry;


import pl.exercise.ferry.ticket.TicketImpl;

import java.util.Map;

public class Ferry  {
    private Map<Integer, TicketImpl> tickets;

    public Ferry(Map<Integer, TicketImpl> tickets) {
        this.tickets = tickets;
    }

    public Map<Integer, TicketImpl> getTickets() {
        return tickets;
    }

    public void setTickets(Map<Integer, TicketImpl> tickets) {
        this.tickets = tickets;
    }
}
