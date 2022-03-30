package org.cinema.ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    List<Ticket> findAllTickets();
    Optional<Ticket> findTicketById(Long id);
    void save(Ticket ticket);
    List<Ticket> listAllTicketsByMovieId(long movieId);
    List<Ticket> listAllTicketsWithDiscountSortByDiscountDesc();
    void deleteTicketById(Long id);
}
