package org.cinema.ticket;

import org.cinema.common.Seat;
import org.cinema.movie.FakeMovieRepository;
import org.cinema.movie.Movie;
import org.cinema.movie.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.cinema.movie.MovieExample.movie1WithNoSeats;
import static org.cinema.movie.MovieExample.movieWith1Seat;

class TicketServiceTest {

    private MovieService movieService;
    private TicketService ticketService;

    @BeforeEach
    void init(){
        movieService = new MovieService(new FakeMovieRepository());
        ticketService = new TicketService(new FakeTicketRepository(), movieService);
    }

    @Test
    public void sellTickets(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        ticketService.sellTickets(List.of(new Seat("A", 15)), 1L);
        // then
        assertThat(ticketService.findTicketById(1L).getSeat()).isEqualTo(new Seat("A", 15));
    }

    @Test
    public void sellTicketsWithDiscount(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        // when
        ticketService.sellTickets(List.of(new Seat("A", 15)), 1L, 0.1);
        // then
        assertThat(ticketService.findTicketById(1L).getSeat()).isEqualTo(new Seat("A", 15));
        assertThat(ticketService.findTicketById(1L).getPrice()).isEqualTo(BigDecimal.valueOf(4.5));
        assertThat(ticketService.findTicketById(1L).getDiscount()).isEqualTo(0.1);
    }

    @Test
    public void listAllTicketsByMovieId(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        ticketService.sellTickets(List.of(new Seat("A", 15),new Seat("B", 15) ), 1L);
        // when
        var result = ticketService.findAllTicketsByMovieId(1L);
        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void listAllTicketsWithDiscountSortByDiscountDesc(){
        // given
        Movie movie = movie1WithNoSeats;
        movieService.addMovie(movie);
        ticketService.sellTickets(List.of(new Seat("A", 15)), 1L);
        ticketService.sellTickets(List.of(new Seat("B", 15)), 1L, 0.1);
        ticketService.sellTickets(List.of(new Seat("C", 15)), 1L, 0.5);
        // when
        var result = ticketService.listAllTicketsWithDiscountSortByDiscountDesc();
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getDiscount()).isEqualTo(0.5);
        assertThat(result.get(1).getDiscount()).isEqualTo(0.1);
    }

    @Test
    public void sellTicketsWhileSeatIsAlreadyOccupied_ThrowsRuntimeException() {
        // given
        Seat seat = new Seat("A", 15);
        Movie movie = movieWith1Seat(seat);
        movieService.addMovie(movie);
        // when
        var exception = catchThrowable(() -> ticketService.sellTickets(List.of(seat), 1L));
        // then
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void sellTicketsWithDiscountWhileSeatIsAlreadyOccupied_ThrowsRuntimeException() {
        // given
        Seat seat = new Seat("A", 15);
        Movie movie = movieWith1Seat(seat);
        movieService.addMovie(movie);
        // when
        var exception = catchThrowable(() -> ticketService.sellTickets(List.of(seat), 1L, 0.1));
        // then
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }


}