package org.cinema;

import org.cinema.common.Seat;
import org.cinema.movie.Movie;
import org.cinema.movie.MovieBuilder;
import org.cinema.movie.MovieService;
import org.cinema.ticket.TicketService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // For presentation
    @Bean
    CommandLineRunner run(MovieService movieService, TicketService ticketService){
        return args -> {
            movieService.addMovie(MovieBuilder.builder()
                    .withName("movie1")
                    .withDate(LocalDateTime.now())
                    .withDescription("1st movie for example")
                    .withLength(120L)
                    .withTicketPrice(BigDecimal.ONE )
                    .build());
            movieService.addMovie(MovieBuilder.builder()
                    .withName("movie2")
                    .withDate(LocalDateTime.now())
                    .withDescription("2st movie for example")
                    .withLength(110L)
                    .withTicketPrice(BigDecimal.TEN )
                    .build());
            ticketService.sellTickets(List.of(new Seat("A", 5)), 1L );
            ticketService.sellTickets(List.of(new Seat("B", 2)), 2L );
        };
    }
}
