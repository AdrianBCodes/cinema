package org.cinema.movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {
    List<Movie> findAllMovies();
    Optional<Movie> findMovieById(Long id);
    Long save(Movie entity);
    List<Movie> findAllMoviesWithBelowOccupiedSeats(int numberOfSeats);
    void deleteMovieById(Long id);
}