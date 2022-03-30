package org.cinema.configuration;

import org.cinema.movie.MovieService;
import org.cinema.movie.infrastructure.SqlMovieRepository;
import org.cinema.ticket.TicketService;
import org.cinema.ticket.infrastructure.SqlTicketRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    MovieService movieService(SqlMovieRepository sqlMovieRepository){
        return new MovieService(sqlMovieRepository);
    }

    @Bean
    TicketService ticketService(SqlTicketRepository sqlTicketRepository, MovieService movieService){
        return new TicketService(sqlTicketRepository, movieService);
    }
}
