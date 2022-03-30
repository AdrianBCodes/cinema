package org.cinema.controller;

import org.cinema.common.Seats;
import org.cinema.ticket.Ticket;
import org.cinema.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    ResponseEntity<List<Ticket>> findAllTickets(){
        return ResponseEntity.ok(ticketService.findAllTickets());
    }

    @GetMapping("/{id}")
    ResponseEntity<Ticket> findTicketById(@PathVariable Long id){
        return ResponseEntity.ok(ticketService.findTicketById(id));
    }

    @GetMapping("/search/{movieId}")
    ResponseEntity<List<Ticket>> findAllTicketsByMovieId(@PathVariable Long movieId){
        return ResponseEntity.ok(ticketService.findAllTicketsByMovieId(movieId));
    }

    @GetMapping("/discount")
    ResponseEntity<List<Ticket>> listAllTicketsWithDiscountSortByDiscountDesc(){
        return ResponseEntity.ok(ticketService.listAllTicketsWithDiscountSortByDiscountDesc());
    }

    @PostMapping("/sell/{movieId}")
    ResponseEntity<?> sellTickets(@RequestBody Seats seats, @PathVariable Long movieId){
        ticketService.sellTickets(seats.seats, movieId);
        return ResponseEntity.ok(seats.seats.size());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteTicketById(@PathVariable Long id){
        ticketService.deleteTicketById(id);
        return ResponseEntity.noContent().build();
    }
}
