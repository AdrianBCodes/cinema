package org.cinema.ticket.infrastructure;

import org.cinema.ticket.Ticket;
import org.cinema.ticket.TicketMapper;
import org.cinema.ticket.TicketRepository;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public interface SqlTicketRepository extends TicketRepository, JpaRepository<TicketEntity, Long> {

    List<Ticket> findAllByMovieId(Long movieId);

    List<Ticket> findAllByDiscountGreaterThan(double value);

    @Override
    default List<Ticket> findAllTickets(){
        return this.findAll().stream().map(TicketMapper::EntityToTicket).collect(Collectors.toList());
    }

    @Override
    default Optional<Ticket> findTicketById(Long id) {
        return this.findById(id).map(TicketMapper::EntityToTicket);
    }

    @Override
    default void save(Ticket ticket) {
        this.save(TicketMapper.TicketToEntity(ticket));
    }

    @Override
    default List<Ticket> listAllTicketsByMovieId(long movieId) {
        return this.findAllByMovieId(movieId);
    }

    @Override
    default List<Ticket> listAllTicketsWithDiscountSortByDiscountDesc() {
        return this.findAllByDiscountGreaterThan(0.0);
    }

    @Override
    default void deleteTicketById(Long id) {
        this.deleteById(id);
    }
}
