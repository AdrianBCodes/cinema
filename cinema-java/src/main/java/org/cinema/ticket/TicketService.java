package org.cinema.ticket;

import org.cinema.common.Seat;
import org.cinema.movie.Movie;
import org.cinema.movie.MovieService;

import java.util.List;

public class TicketService {
    private final TicketRepository ticketRepository;
    private final MovieService movieService;

    public TicketService(TicketRepository ticketRepository, MovieService movieService) {
        this.ticketRepository = ticketRepository;
        this.movieService = movieService;
    }

    public List<Ticket> findAllTickets(){
        return ticketRepository.findAllTickets();
    }

    public Ticket findTicketById(Long id){
        var result = ticketRepository.findTicketById(id);
        if(result.isEmpty())
            throw new RuntimeException("Ticket with id: " + id + " has not been found");
        return result.get();
    }

    public List<Ticket> findAllTicketsByMovieId(long movieId){
        return ticketRepository.listAllTicketsByMovieId(movieId);
    }

    public List<Ticket> listAllTicketsWithDiscountSortByDiscountDesc(){
        return ticketRepository.listAllTicketsWithDiscountSortByDiscountDesc();
    }

    public void sellTickets(List<Seat> seats, Long movieId){
        sellTickets(seats, movieId, 0.0);
    }

    public void sellTickets(List<Seat> seats, Long movieId, double discount){
        var movie = movieService.findMovieById(movieId);
        var isOccupied = movie.getOccupiedSeats().stream().anyMatch(seats::contains);
        if(isOccupied)
            throw new RuntimeException("This seat is already occupied");
        seats.forEach(seat -> {
            var soldTicket = new Ticket(seat, movieId, movie.getTicketPrice(), discount);
            ticketRepository.save(soldTicket);
            movieService.assignSeatToMovie(movie, seat);
        });
    }

    public void deleteTicketById(Long id){
        ticketRepository.deleteTicketById(id);
    }

}
