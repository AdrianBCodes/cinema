package org.cinema.ticket;

import java.util.*;
import java.util.stream.Collectors;

public class FakeTicketRepository implements TicketRepository{
    private final Map<Long, Ticket> tickets = new HashMap<>();

    @Override
    public List<Ticket> findAllTickets() {
        return tickets.values().stream().toList();
    }

    @Override
    public Optional<Ticket> findTicketById(Long id) {
        return Optional.ofNullable(tickets.get(id));
    }

    @Override
    public void save(Ticket entity) {
        if(entity.getId() == null){
            var index = tickets.keySet().isEmpty() ? 1 : Collections.max(tickets.keySet())+1;
            var indexedTicket = new Ticket(index, entity.getSeat(), entity.getMovieId(), entity.getPrice(), entity.getDiscount());
            tickets.put(index, indexedTicket);
            return;
        }
        tickets.put(entity.getId(), entity);
    }

    @Override
    public List<Ticket> listAllTicketsByMovieId(long movieId) {
        return tickets.values().stream().filter(ticket -> ticket.getMovieId().equals(movieId)).collect(Collectors.toList());
    }

    @Override
    public List<Ticket> listAllTicketsWithDiscountSortByDiscountDesc() {
        return tickets.values().stream().filter(ticket -> ticket.getDiscount() > 0.0).sorted(Comparator.comparing(Ticket::getDiscount).reversed()).collect(Collectors.toList());
    }

    @Override
    public void deleteTicketById(Long id) {
        tickets.remove(id);
    }
}
