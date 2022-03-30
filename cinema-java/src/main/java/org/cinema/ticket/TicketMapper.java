package org.cinema.ticket;

import org.cinema.ticket.infrastructure.TicketEntity;

public class TicketMapper {

    public static TicketEntity TicketToEntity(Ticket ticket){
        return new TicketEntity(ticket.getId(), ticket.getSeat(), ticket.getMovieId(), ticket.getPrice(), ticket.getDiscount());
    }

    public static Ticket EntityToTicket(TicketEntity entity){
        return new Ticket(entity.getId(), entity.getSeat(), entity.getMovieId(), entity.getPrice(), entity.getDiscount());
    }

}
