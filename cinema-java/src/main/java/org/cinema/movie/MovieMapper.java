package org.cinema.movie;

import org.cinema.movie.infrastructure.MovieEntity;

public class MovieMapper {

    public static Movie entityToMovie(MovieEntity entity){
        return new Movie(entity.getId(), entity.getName(), entity.getDescription(), entity.getDate(), entity.getTicketPrice(), entity.getOccupiedSeats().seats, entity.getLength());
    }

    public static MovieEntity movieToEntity(Movie movie){
        return new MovieEntity(movie.getId(), movie.getName(), movie.getDescription(), movie.getDate(), movie.getTicketPrice(), movie.getOccupiedSeats(), movie.getLength());
    }
}
